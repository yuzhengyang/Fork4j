package pers.yuzhyn.azylee.core.datas.encrypts;

import pers.yuzhyn.azylee.core.datas.strings.StringFillTool;
import pers.yuzhyn.azylee.core.logs.Alog;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Tool {
    public static String encrypt(String s) {
        if (null == s) s = "";

        String md5code = "";
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("MD5").digest(s.getBytes());
        } catch (NoSuchAlgorithmException e) {
            Alog.e("java.security.MessageDigest 获取MD5算法失败");
        }
        md5code = new BigInteger(1, secretBytes).toString(16);
        md5code = StringFillTool.suffixFill(md5code, 32, "0");
        return md5code;
    }

    public static String encryptTwice(String s) {
        return encrypt(encrypt(s));
    }

    public static String encryptUpper(String s) {
        return encrypt(s).toUpperCase();
    }

    public static void main(String[] args) {
        Alog.i(encrypt("胡天八月即飞雪"));
//        Alog.i(encrypt2("胡天八月即飞雪"));
        Alog.w("----------------------------------");
        Alog.i(encryptTwice("胡天八月即飞雪"));
        Alog.i(encryptUpper("胡天八月即飞雪"));
        Alog.i(encrypt("胡天八月即飞雪胡天八月即飞雪胡天八月即飞雪胡天八月即飞雪"));
//        Alog.i(toHexString("胡天八月即飞雪".getBytes()));
        Alog.w("----------------------------------");
    }
}
