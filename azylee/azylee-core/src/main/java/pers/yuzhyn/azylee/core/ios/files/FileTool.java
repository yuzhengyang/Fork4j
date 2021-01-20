package pers.yuzhyn.azylee.core.ios.files;

import pers.yuzhyn.azylee.core.ios.dirs.DirTool;
import pers.yuzhyn.azylee.core.logs.Alog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileTool {
    public static boolean isExist(String pathName) {
        try {
            File file = new File(pathName);
            return file.exists() && file.isFile();
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean create(String pathName) {
        if (!FileTool.isExist(pathName)) {
            try {
                if (DirTool.create(DirTool.parent(pathName))) {
                    File file = new File(pathName);
                    if (file.createNewFile()) {
                        return FileTool.isExist(pathName);
                    }
                }
            } catch (Exception ex) {
                Alog.e(ex.getMessage());
            }
            return false;
        }
        return true;
    }

    public static boolean recreate(String pathName) {
        if (FileTool.delete(pathName)) {
            return FileTool.create(pathName);
        }
        return false;
    }

    public static boolean delete(String pathName) {
        if (FileTool.isExist(pathName)) {
            try {
                File file = new File(pathName);
                if (file.delete()) {
                    return !FileTool.isExist(pathName);
                }
            } catch (Exception ex) {
            }
            return false;
        }
        return true;
    }

    public static boolean inputStreamToFile(InputStream inputStream, String targetFilePath, boolean overwrite) {
        try {
            if (FileTool.isExist(targetFilePath) && overwrite == false) {
                return true;
            }
            int index;
            byte[] bytes = new byte[1024];
            FileOutputStream downloadFile = new FileOutputStream(targetFilePath);
            while ((index = inputStream.read(bytes)) != -1) {
                downloadFile.write(bytes, 0, index);
                downloadFile.flush();
            }
            downloadFile.close();
            inputStream.close();
            return true;
        } catch (Exception ex) {
            Alog.e(ex.getMessage());
            return false;
        }
    }
}
