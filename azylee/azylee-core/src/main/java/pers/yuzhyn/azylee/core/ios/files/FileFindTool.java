package pers.yuzhyn.azylee.core.ios.files;

import pers.yuzhyn.azylee.core.datas.collections.ListTool;
import pers.yuzhyn.azylee.core.ios.dirs.DirFindTool;
import pers.yuzhyn.azylee.core.ios.dirs.DirTool;
import pers.yuzhyn.azylee.core.logs.Alog;

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

    public static void main(String[] args) {
        Alog.i(getFiles("D:\\temp"));
//        Alog.i(DirFindTool.getPath("D:\\temp"));
    }
}
