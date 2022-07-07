package com.yuzhyn.azylee.core.ios.files;

import com.yuzhyn.azylee.core.datas.collections.ListTool;
import com.yuzhyn.azylee.core.datas.datetimes.DateTimeFormat;
import com.yuzhyn.azylee.core.datas.datetimes.DateTimeFormatPattern;
import com.yuzhyn.azylee.core.ios.dirs.DirTool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文件版本备份管理器
 */
public class FileVersionManager {
    private static final String FILE_SP = ".V.";
    private static final String FILE_EXT = ".AZLFVM";

    private String fileName = null;
    private String pathName = null;
    private String path = null;
    private int versionSize = 1;

    /**
     * 私有空构造方法
     */
    private FileVersionManager() {
    }

    /**
     * 初始化管理器
     * @param pathName 参数
     */
    public FileVersionManager(String pathName) {
        this(pathName, 5);
    }

    /**
     * 初始化管理器
     * @param pathName 参数
     * @param versionSize 参数
     */
    public FileVersionManager(String pathName, int versionSize) {
        this.pathName = pathName;
        this.fileName = FileTool.getName(pathName);
        this.path = FileTool.getPath(pathName);
        this.versionSize = versionSize;
    }

    /**
     * 计算下一版本文件名
     * @return 返回 返回
     */
    private String nextName() {
        return this.fileName + FILE_SP + DateTimeFormat.toStr(new Date(), DateTimeFormatPattern.SHORT_DATETIME) + FILE_EXT;
    }

    /**
     * 创建下一版本文件
     * @return 返回 返回
     */
    public String create() {
        // 创建历史版本备份
        String name = nextName();
        FileTool.copy(this.pathName, DirTool.combine(this.path, name));
        // 清理多余的历史版本
        this.clean(this.versionSize);
        return name;
    }

    /**
     * 清理所有历史版本文件
     */
    public void clean() {
        clean(0);
    }

    /**
     * 清理历史版本文件（保留x个）
     * @param retain 参数
     */
    public void clean(int retain) {
        List<String> list = versionList();
        if (ListTool.ok(list)) {
            for (int i = 0; i < list.size() - retain; i++) {
                FileTool.delete(DirTool.combine(this.path, list.get(i)));
            }
        }
    }

    /**
     * 版本文件列表
     * @return 返回 返回
     */
    public List<String> versionList() {
        List<String> result = new ArrayList<>();
        List<String> files = FileFindTool.getFiles(this.path);
        if (ListTool.ok(files)) {
            for (String file : files) {
                if (file.startsWith(fileName) && file.contains(FILE_SP) && file.endsWith(FILE_EXT)) {
                    result.add(file);
                }
            }
        }
        return result.stream().sorted().collect(Collectors.toList());
    }

//    public static void main(String[] args) {
//        FileVersionManager fvm = new FileVersionManager("D:\\temp\\MobaX.zip", 2);
//        fvm.create();
//
//        Alog.i(fvm.versionList());
//
//        fvm.clean();
//    }
}
