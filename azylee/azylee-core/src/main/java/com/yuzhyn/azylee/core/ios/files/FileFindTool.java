package com.yuzhyn.azylee.core.ios.files;

import com.yuzhyn.azylee.core.logs.Alog;
import com.yuzhyn.azylee.core.datas.collections.ListTool;
import com.yuzhyn.azylee.core.ios.dirs.DirTool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileFindTool {
    public static List<String> getFiles(String path) {
        List<String> result = new ArrayList<>();
        if (DirTool.isExist(path)) {
            File file = new File(path);
            File[] fileList = file.listFiles();
            if (ListTool.ok(fileList)) {
                for (File f : fileList) {
                    if (f.isFile()) result.add(f.getName());
                }
            }
        }
        return result;
    }

    public static List<String> getAllFiles(String path, String ext) {
        List<String> fileNames = new ArrayList<>();
        findFileList(path, fileNames, ext);
        return fileNames;
    }

    private static void findFileList(String filepath, List<String> fileNames, String ext) {
        File dir = new File(filepath);
        // 判断是否存在目录
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        // 读取目录下的所有目录文件信息
        String[] files = dir.list();
        // 循环，添加文件名或回调自身
        for (int i = 0; i < files.length; i++) {
            File file = new File(dir, files[i]);
            // 如果文件
            if (file.isFile()) {
                // 添加文件全路径名
                String f = DirTool.combine(dir.getPath(), file.getName());
                if (f.endsWith(ext)) fileNames.add(f);
            } else {
                // 如果是目录
                // 回调自身继续查询
                findFileList(file.getPath(), fileNames, ext);
            }
        }
    }

    public static void main(String[] args) {
//        Alog.i(getFiles("D:\\temp\\ziptest\\解压后\\66666"));

        List<String> files = new ArrayList<>();
//        findFileList("D:\\temp\\ziptest\\解压后\\66666", files);
        Alog.i(files);
//        Alog.i(DirFindTool.getPath("D:\\temp"));
    }
}
