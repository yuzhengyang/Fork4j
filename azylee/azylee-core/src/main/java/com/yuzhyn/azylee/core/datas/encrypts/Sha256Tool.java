package com.yuzhyn.azylee.core.datas.encrypts;

import com.yuzhyn.azylee.core.logs.Alog;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256Tool {

    public static String encrypt(String s) {
        return encrypt(s.getBytes());
    }

    public static String encrypt(byte[] data) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(data);
            encodeStr = HexTool.toHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    public static void main(String[] args) {
        String text = "春风不度玉门关";
        Alog.i(text);
        Alog.i(Sha256Tool.encrypt(text));
    }
}
