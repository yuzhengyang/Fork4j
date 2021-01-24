package pers.yuzhyn.azylee.core.ios.files;

import pers.yuzhyn.azylee.core.datas.encrypts.Md5Tool;
import pers.yuzhyn.azylee.core.datas.encrypts.Sha1Tool;
import pers.yuzhyn.azylee.core.datas.strings.StringConst;
import pers.yuzhyn.azylee.core.datas.strings.StringTool;
import pers.yuzhyn.azylee.core.ios.dirs.DirTool;
import pers.yuzhyn.azylee.core.logs.Alog;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    public static boolean copy(String source, String target) {
        try (FileInputStream inputStream = new FileInputStream(new File(source));
             FileOutputStream outputStream = new FileOutputStream(new File(target));
             FileChannel inputChannel = inputStream.getChannel();
             FileChannel outputChannel = outputStream.getChannel()) {

            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
            return true;
        } catch (Exception ex) {
            Alog.e(ex.getMessage());
        }
        return false;
    }

    public static boolean move(String source, String target) {
        boolean copyFlag = FileTool.copy(source, target);
        if (copyFlag) {
            boolean deleteFlag = FileTool.delete(source);
        }
        return copyFlag;
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
//        {
//            Alog.i(FileTool.getExt("E:\\test\\test.dxf"));
//            Alog.i(FileTool.getExt("E:\\test\\test."));
//            Alog.i(FileTool.getExt("E:\\test\\.dxf"));
//            Alog.i(FileTool.getExt("E:\\test\\"));
//            Alog.i(FileTool.getExt("张三和挖掘机.pdf"));
//        }
//        boolean flag = move("D:/code/projects/my-github-projects/BigBird/03_SRC/bigbird/bigbird_data/sysfile/temp/0f09ef4cece5487082a73aa39adcef9d",
//                "D:/code/projects/my-github-projects/BigBird/03_SRC/bigbird/bigbird_data/sysfile/202101/0f09ef4cece5487082a73aa39adcef9d");
//        Alog.i("move:" + flag);

//        boolean flag = move("D:\\code\\projects\\my-github-projects\\BigBird\\03_SRC\\bigbird\\bigbird_data\\sysfile\\temp\\fe7ba94875774e20bfae92070bb856e5",
//                "D:\\code\\projects\\my-github-projects\\BigBird\\03_SRC\\bigbird\\bigbird_data\\sysfile\\202101\\fe7ba94875774e20bfae92070bb856e5");
//        Alog.i("move:" + flag);

        boolean flag = delete("D:/code/projects/my-github-projects/BigBird/03_SRC/bigbird/bigbird_data/sysfile/temp/6b2c9a84dc9b47bea3756b880210b388");
        Alog.i("move:" + flag);
    }
}
