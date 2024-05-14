package com.yuzhyn.azylee.core.ios.zips;

import com.yuzhyn.azylee.core.ios.dirs.DirTool;
import com.yuzhyn.azylee.core.ios.files.FileTool;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipTool {

    /**
     * 压缩（未测试）
     *
     * @return 返回 返回
     * @throws IOException 异常
     */
    public static boolean zip() throws IOException {
        //压缩文件名称与位置
        OutputStream outputStream = new FileOutputStream("f://test.zip");
        //获取压缩文件输出流
        ZipOutputStream out = new ZipOutputStream(outputStream);
        //被压缩的文件
        FileInputStream fis = new FileInputStream("F://video.mp4");
        //video.mp4在压缩包zip 中的音乐名称
        out.putNextEntry(new ZipEntry("视频.mp4"));
        int len;
        byte[] buffer = new byte[1024];
        // 读入需要下载的文件的内容，打包到zip文件
        while ((len = fis.read(buffer)) > 0) {
            //写入压缩文件输出流中(压缩文件zip中)
            out.write(buffer, 0, len);
        }
        fis.close();

        //第二个被压缩文件
        FileInputStream fis1 = new FileInputStream("F://picture.jpg");
        //picture.jpg在压缩包中的名称 图片.jpg
        out.putNextEntry(new ZipEntry("图片.jpg"));
        int len1;
        byte[] buffer1 = new byte[1024];
        // 读入需要下载的文件的内容，打包到zip文件
        while ((len1 = fis1.read(buffer1)) > 0) {
            out.write(buffer1, 0, len1);
        }
        //关闭流
        out.closeEntry();
        fis1.close();
        out.close();
        return true;
    }

    /**
     * 解压zip文件
     *
     * @param zipFilePath  输入的zip文件路径
     * @param targetPath   输出的文件夹路径,不存在会则创建
     * @param targetFolder 输出的文件名
     * @throws IOException 当然报io错误咯
     */
    public static void unzip(String zipFilePath, String targetPath, String targetFolder, Function<Map<String, Object>, Boolean> callback) throws IOException {

        String finalTargetPath = DirTool.combine(targetPath, targetFolder);
        if (!DirTool.create(finalTargetPath)) throw new IOException("创建文件夹失败");
        if (!FileTool.isExist(zipFilePath)) throw new IOException("未发现zip文件");

        Integer fileCount = 0, fileIndex = 0;
        Long curFileSize = 0L, curFileRead = 0L;

        File file = new File(zipFilePath);
        //用GBK能解决很多问题
        ZipFile zipFile = new ZipFile(file, Charset.forName("GBK"));
        Enumeration<?> zipE = zipFile.entries();
        fileCount = zipFile.size();

        while (zipE.hasMoreElements()) {
            fileIndex++;
            curFileRead = 0L;
            ZipEntry zipEntry = (ZipEntry) zipE.nextElement();
            String savePath = DirTool.combine(finalTargetPath, zipEntry.getName());
            if (zipEntry.isDirectory()) {
                DirTool.create(savePath);
            } else {
                File uFile = new File(savePath);
                // 覆盖（先删除，再创建）
                FileTool.delete(savePath);
                uFile.createNewFile();

                curFileSize = zipEntry.getSize();
                try (InputStream inputStream = zipFile.getInputStream(zipEntry);
                     FileOutputStream ofs = new FileOutputStream(uFile)) {
                    int length;
                    byte[] bytes = new byte[1024];
                    while ((length = inputStream.read(bytes, 0, bytes.length)) != -1) {
                        ofs.write(bytes, 0, length);
                        curFileRead += length;

                        boolean isContinue = callback.apply(Map.of("fileCount", fileCount,
                                "fileIndex", fileIndex,
                                "curFileSize", curFileSize,
                                "curFileRead", curFileRead,
                                "curFileName", zipEntry.getName()));
                        if (!isContinue) throw new IOException("user break");
                    }
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
        callback.apply(Map.of("fileCount", fileCount,
                "fileIndex", fileIndex,
                "curFileSize", curFileSize,
                "curFileRead", curFileRead,
                "curFileName", ""));
    }

    public static void main(String[] args) throws IOException {
        // unzip("D:\\temp\\ziptest\\temp.zip", "D:\\temp\\ziptest\\解压后", "66666");

    }
}
