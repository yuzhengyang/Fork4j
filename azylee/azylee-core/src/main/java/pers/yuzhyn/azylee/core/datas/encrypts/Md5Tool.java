package pers.yuzhyn.azylee.core.datas.encrypts;

import pers.yuzhyn.azylee.core.datas.strings.StringFillTool;
import pers.yuzhyn.azylee.core.logs.Alog;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Tool {

    private static final char[] hexCode = "0123456789ABCDEF".toCharArray();

    /**
     * 将已经md5运算过的byte[]结果格式化为String
     * @param data
     * @return
     */
    public static String toHexString(byte[] data) {
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }

    public static String encrypt(String s) {
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


    public static void main(String[] args) {
        Alog.i(encrypt("胡天八月即飞雪"));
        Alog.i(toHexString("胡天八月即飞雪".getBytes()));
    }
}
