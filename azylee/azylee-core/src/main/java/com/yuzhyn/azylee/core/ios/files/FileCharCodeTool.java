package com.yuzhyn.azylee.core.ios.files;

import com.yuzhyn.azylee.core.ios.buffers.MappedByteBufferTool;
import com.yuzhyn.azylee.core.logs.Alog;
import com.yuzhyn.azylee.core.datas.encrypts.HexTool;
import com.yuzhyn.azylee.core.datas.encrypts.Sha1Tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;

/**
 * 文件特征码工具
 * md5、sha1
 */
public class FileCharCodeTool {

    /**
     * 计算文件 MD5
     *
     * @param file
     * @return
     */
    public static String md5(File file) {
        try (InputStream stream = Files.newInputStream(file.toPath(), StandardOpenOption.READ)) {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] buf = new byte[8192];
            int len;
            while ((len = stream.read(buf)) > 0) {
                digest.update(buf, 0, len);
            }
            return HexTool.toHex(digest.digest());
        } catch (Exception e) {
            return "";
        }
    }

    public static String md5(String pathName) {
        return FileCharCodeTool.md5(new File(pathName));
    }

    /**
     * 计算SHA1码
     *
     * @param file
     * @return
     */
    public static String sha1(File file) {
        try (FileInputStream in = new FileInputStream(file);
             FileChannel ch = in.getChannel()) {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
            MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            messagedigest.update(byteBuffer);
            MappedByteBufferTool.unmap(byteBuffer);
            return Sha1Tool.encrypt(messagedigest.digest());
        } catch (Exception ex) {
            Alog.e(ex.getMessage());
            return "";
        }
    }

    public static String sha1(String pathName) {
        return FileCharCodeTool.sha1(new File(pathName));
    }

    public static void main(String[] args) {
//        {
//            String source = "E:\\testfile\\禅与摩托车维修艺术.pdf";
//            String target = "E:\\testfile\\禅与摩托车维修艺术-test.pdf";
//            FileTool.copy(source, target);
//            Alog.i(FileCharCodeTool.md5(target));
//            Alog.i(FileCharCodeTool.sha1(target));
//
//            boolean deleteFlag = FileTool.delete(target);
//            Alog.i("deleteFlag: " + deleteFlag);
//        }
    }
}
