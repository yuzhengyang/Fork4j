package com.yuzhyn.azylee.core.ios.txts;

import com.yuzhyn.azylee.core.datas.keyvalues.KeyValueBag;
import com.yuzhyn.azylee.core.ios.files.FileTool;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class IniTool {

    public static String read(String fileName, String section, String key, String defaultValue) {
        List<String> lines = TxtTool.readLine(fileName);
        int[] position = position(lines, section, key);
        if (position[0] != -1 && position[1] != -1) {
            String line = lines.get(position[1]);
            String resultValue = line.substring(line.indexOf("=") + 1);
            return resultValue;
        }
        return defaultValue;
    }

    public static boolean write(String fileName, String section, String key, String value) {
        // 检查是否有配置文件，没有则创建一个
        if (!FileTool.isExist(fileName)) FileTool.create(fileName);

        // 读取内容并定位位置
        List<String> lines = TxtTool.readLine(fileName);
        int[] position = position(lines, section, key);

        // 存在section
        if (position[0] != -1) {
            // 存在key，直接修改即可
            if (position[1] != -1) {
                String line = key + "=" + value;
                lines.set(position[1], line);
            } else {
                String line = key + "=" + value;
                lines.add(position[0] + 1, line);
            }
        } else {
            lines.add("[" + section + "]");
            lines.add(key + "=" + value);
        }

        return saveFile(fileName, lines);
    }

    /**
     * 定位配置位置
     *
     * @param lines
     * @param section
     * @param key
     * @return 返回配置在哪一行 [section, key]
     */
    private static int[] position(List<String> lines, String section, String key) {
        int sectionIndex = -1;
        int keyIndex = -1;
        String currentSection = "";
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.startsWith("[") && line.endsWith("]")) {
                currentSection = line.substring(1, line.length() - 1);
                if (currentSection.equals(section)) {
                    sectionIndex = i;
                }
            }
            if (currentSection.equals(section) && line.startsWith(key + "=")) {
                keyIndex = i;
                break;
            }
        }
        return new int[]{sectionIndex, keyIndex};
    }

    /**
     * 保存ini配置文件 使用多文件缓冲
     *
     * @param file
     * @param lines
     * @return
     */
    private static boolean saveFile(String file, List<String> lines) {
        String oldFile = file + ".old";
        FileTool.delete(oldFile);

        FileTool.move(file, oldFile);
        TxtTool.create(file, lines);

        if (FileTool.isExist(file) && FileTool.getSize(file) > 0) {
            if (FileTool.delete(oldFile)) {
                return true;
            }
        } else {
            FileTool.delete(file);
            FileTool.move(oldFile, file);
        }
        return false;
    }

}
