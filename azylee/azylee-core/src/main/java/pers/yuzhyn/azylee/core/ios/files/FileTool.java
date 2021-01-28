package pers.yuzhyn.azylee.core.ios.files;

import pers.yuzhyn.azylee.core.datas.strings.StringConst;
import pers.yuzhyn.azylee.core.datas.strings.StringTool;
import pers.yuzhyn.azylee.core.ios.dirs.DirTool;
import pers.yuzhyn.azylee.core.logs.Alog;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Optional;

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
                file.delete();
                file.deleteOnExit();
                return !FileTool.isExist(pathName);
            } catch (Exception ex) {
            }
            return false;
        }
        return true;
    }

    /**
     * 复制文件（默认覆盖目标已有文件）
     *
     * @param source
     * @param target
     * @return
     */
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

    /**
     * 复制文件（覆盖选项自选）
     *
     * @param source
     * @param target
     * @param overwrite
     * @return
     */
    public static boolean copy(String source, String target, boolean overwrite) {
        if (overwrite) {
            return FileTool.copy(source, target);
        } else {
            if (FileTool.isExist(target)) return true;
            else return false;
        }
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

//        {
//            boolean flag = delete("D:/code/projects/my-github-projects/BigBird/03_SRC/bigbird/bigbird_data/sysfile/temp/6b2c9a84dc9b47bea3756b880210b388");
//            Alog.i("move:" + flag);
//        }

//
//        String source = "E:\\testfile\\a.txt";
//        String target = "E:\\testfile\\b.txt";
//        Alog.i("copy:" + FileTool.copy(source, target));

//        try{
//            int a = 0/0;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
