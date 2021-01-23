package pers.yuzhyn.azylee.core.ios.files;

import pers.yuzhyn.azylee.core.datas.encrypts.Md5Tool;
import pers.yuzhyn.azylee.core.datas.encrypts.Sha1Tool;
import pers.yuzhyn.azylee.core.logs.Alog;

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
            return Md5Tool.toHexString(digest.digest());
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
        try {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
            FileInputStream in = new FileInputStream(file);
            FileChannel ch = in.getChannel();
            MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            messagedigest.update(byteBuffer);
            return Sha1Tool.bufferToHex(messagedigest.digest());
        } catch (Exception ex) {
            Alog.e(ex.getMessage());
            return "";
        }
    }

    public static String sha1(String pathName) {
        return FileCharCodeTool.sha1(new File(pathName));
    }

    public static void main(String[] args) {

        Alog.i(FileCharCodeTool.md5("E:\\testfile\\禅与摩托车维修艺术.pdf"));
        Alog.i(FileCharCodeTool.sha1("E:\\testfile\\禅与摩托车维修艺术.pdf"));
    }
}
