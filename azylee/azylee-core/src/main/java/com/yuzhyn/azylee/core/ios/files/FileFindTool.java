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

    public static void findFileList(String filepath, List<String> fileNames) {
        File dir = new File(filepath);
        // 判断是否存在目录
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        String[] files = dir.list();// 读取目录下的所有目录文件信息
        for (int i = 0; i < files.length; i++) {// 循环，添加文件名或回调自身
            File file = new File(dir, files[i]);
            if (file.isFile()) {// 如果文件
                fileNames.add(dir + "\\" + file.getName());// 添加文件全路径名
            } else {// 如果是目录
                findFileList(file.getPath(), fileNames);// 回调自身继续查询
            }
        }
    }

    public static void main(String[] args) {
//        Alog.i(getFiles("D:\\temp\\ziptest\\解压后\\66666"));

        List<String> files = new ArrayList<>();
        findFileList("D:\\temp\\ziptest\\解压后\\66666", files);
        Alog.i(files);
//        Alog.i(DirFindTool.getPath("D:\\temp"));
    }
}
