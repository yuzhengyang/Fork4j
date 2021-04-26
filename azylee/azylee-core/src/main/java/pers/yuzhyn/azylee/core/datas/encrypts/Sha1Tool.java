package pers.yuzhyn.azylee.core.datas.encrypts;

import pers.yuzhyn.azylee.core.logs.Alog;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha1Tool {

    public static String encrypt(String s) {
        return encrypt(s.getBytes());
    }

    public static String encrypt(byte[] data) {
        try {
            // 获取指定摘要算法的messageDigest对象
            // 此处的sha代表sha1
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");

            // 调用digest方法，进行加密操作
            byte[] cipherBytes = messageDigest.digest(data);

            String cipherStr = HexTool.toHex(cipherBytes);
            return cipherStr;
        } catch (NoSuchAlgorithmException ex) {
            return "";
        }
    }

    public static void main(String[] args) {
        String text = "大漠孤烟直";
        Alog.i(text);
        Alog.i(Sha1Tool.encrypt(text));
    }

}
