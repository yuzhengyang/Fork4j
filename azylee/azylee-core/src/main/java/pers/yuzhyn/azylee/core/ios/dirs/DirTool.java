package pers.yuzhyn.azylee.core.ios.dirs;

import pers.yuzhyn.azylee.core.logs.Log;

import java.io.File;

public class DirTool {
    public static boolean isExist(String path) {
        try {
            File file = new File(path);
            return file.exists() && file.isDirectory();
        } catch (Exception ex) {
            return false;
        }
    }

    public static String parent(String path) {
        try {
            File file = new File(path);
            String strParentDirectory = file.getParent();
            return strParentDirectory;
        } catch (Exception ex) {
            Log.e(ex.getMessage());
        }
        return null;
    }

    public static boolean create(String path) {
        if (!DirTool.isExist(path)) {
            try {
                File file = new File(path);
                return file.mkdirs();
            } catch (Exception ex) {
                Log.e(ex.getMessage());
                return false;
            }
        }
        return true;
    }
}
