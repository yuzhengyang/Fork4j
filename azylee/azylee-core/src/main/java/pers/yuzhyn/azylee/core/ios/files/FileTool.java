package pers.yuzhyn.azylee.core.ios.files;

import pers.yuzhyn.azylee.core.datas.strings.StringConst;
import pers.yuzhyn.azylee.core.datas.strings.StringTool;
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

    /**
     * 获取文件扩展名
     *
     * @param s
     * @return
     */
    public static String getExt(String s) {
        if (StringTool.ok(s)) {
            String fileName = s;
            int fileNameIndex = s.lastIndexOf(StringConst.FILE_SEPARATOR);
            if (fileNameIndex > 0) {
                fileName = s.substring(fileNameIndex + 1);
            }
            if (StringTool.ok(fileName)) {
                int extNameIndex = fileName.lastIndexOf(".");
                String extName = fileName.substring(extNameIndex + 1);
                return extName;
            }
        }
        return "";
    }

    public static void main(String[] args) {
//        {
//            String filePath = "E:\\test\\test.dxf";
//            String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
//            String name = fileName.substring(0, fileName.lastIndexOf("."));
//            Alog.i(name);
//        }
        {
            Alog.i(FileTool.getExt("E:\\test\\test.dxf"));
            Alog.i(FileTool.getExt("E:\\test\\test."));
            Alog.i(FileTool.getExt("E:\\test\\.dxf"));
            Alog.i(FileTool.getExt("E:\\test\\"));
            Alog.i(FileTool.getExt("张三和挖掘机.pdf"));
        }
    }
}
