package com.yuzhyn.azylee.core.ios.txts;

import com.yuzhyn.azylee.core.datas.strings.StringConst;
import com.yuzhyn.azylee.core.ios.files.FileTool;
import com.yuzhyn.azylee.core.logs.Alog;
import com.yuzhyn.azylee.core.ios.dirs.DirTool;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TxtTool {

    public static String read(String pathName) {
        List<String> result = readLine(pathName);
        return String.join("", result);
    }

    public static List<String> readLine(String pathName) {
        List<String> result = null;
        if (FileTool.isExist(pathName)) {
            try {
                File file = new File(pathName);
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                String line = null;
                result = new ArrayList<>();
                while ((line = br.readLine()) != null) {
                    result.add(line);
                }
            } catch (Exception ex) {
            }
        }
        return result;
    }

    public static boolean append(String pathName, String txt) {
        return append(pathName, Arrays.asList(txt));
    }

    public static boolean append(String pathName, List<String> lines) {
        FileTool.create(pathName);
        if (FileTool.isExist(pathName)) {
            FileWriter writer = null;
            try {
                File file = new File(pathName);
                writer = new FileWriter(file, true);
                for (String line : lines) {
                    writer.write(StringConst.NEWLINE);
                    writer.write(line);
                }
                return true;
            } catch (Exception ex) {
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
        return false;
    }

    public static boolean create(String pathName, List<String> lines) {
        FileTool.create(pathName);
        if (FileTool.isExist(pathName)) {
            FileWriter writer = null;
            try {
                File file = new File(pathName);
                writer = new FileWriter(file, false);
                for (String line : lines) {
                    writer.write(line);
                    writer.write(StringConst.NEWLINE);
                }
                return true;
            } catch (Exception ex) {
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String.join("-", "a", "b", "c");

//        Alog.e(DirTool.parent("d://niu"));
//        Alog.e(DirTool.parent("d://"));
//        Alog.e(DirTool.parent("/opt/ssa"));
//        Alog.e(DirTool.parent("/opt"));
//        Alog.e(DirTool.parent("/"));
//        {
//            String pp = "d:\\tmp\\niu\\ya\\t1.txt";
//            FileTool.recreate(pp);
//            long time = System.currentTimeMillis();
//            for (int i = 0; i < 10; i++) {
//                TxtTool.append(pp, "UuidTool.get()");
//            }
//            long time2 = System.currentTimeMillis();
//            System.out.println("append 方法 执行 共用时：" + (time2 - time));
//
//
//        }
    }
}
