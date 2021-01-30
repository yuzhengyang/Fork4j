package pers.yuzhyn.azylee.core.ios.dirs;

import pers.yuzhyn.azylee.core.datas.collections.ListTool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirFindTool {
    public static List<String> getPath(String path) {
        List<String> result = new ArrayList<>();
        if (DirTool.isExist(path)) {
            File file = new File(path);
            File[] fileList = file.listFiles();
            if (ListTool.ok(fileList)) {
                for (File f : fileList) {
                    if (f.isDirectory()) result.add(f.getName());
                }
            }
        }
        return result;
    }
}
