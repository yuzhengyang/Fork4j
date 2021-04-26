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

    /**
     * 自定义混合md5加密（适用于密码md5加密）
     * 长度：64位
     *
     * @param s
     * @return
     */
    public static String encryptMix(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            String _m = encrypt(String.valueOf(c));
            stringBuilder.append(_m);
        }
        return encrypt(stringBuilder.toString()) + encryptTwice(stringBuilder.toString());
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
        Alog.i(encryptMix("胡天八月即飞雪"));
    }
}
