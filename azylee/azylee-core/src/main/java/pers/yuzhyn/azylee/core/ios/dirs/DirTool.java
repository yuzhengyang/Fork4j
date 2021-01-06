package pers.yuzhyn.azylee.core.ios.dirs;

import java.io.File;

public class DirTool {
    public static boolean isExist(String pathName) {
        try {
            File file = new File(pathName);
            return file.exists() && file.isDirectory();
        } catch (Exception ex) {
            return false;
        }
    }
}
