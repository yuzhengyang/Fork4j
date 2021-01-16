package pers.yuzhyn.azylee.core.datas.encrypts;

import pers.yuzhyn.azylee.core.datas.strings.StringFillTool;
import pers.yuzhyn.azylee.core.logs.Alog;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Tool {

    public static String encrypt(String s) {
        String md5code = "";
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(s.getBytes());
        } catch (NoSuchAlgorithmException e) {
            Alog.e("java.security.MessageDigest 获取MD5算法失败");
        }
        md5code = new BigInteger(1, secretBytes).toString(16);
        md5code = StringFillTool.suffixFill(md5code, 32, "0");
        return md5code;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("0"));
    }
}
