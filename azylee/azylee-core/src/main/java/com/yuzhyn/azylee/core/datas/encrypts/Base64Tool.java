package com.yuzhyn.azylee.core.datas.encrypts;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Tool {

    public static String encode(byte[] bytes) {
        String base64encodedString = Base64.getEncoder().encodeToString(bytes);
        return base64encodedString;
    }

    public static String encodeUtf8(String s) throws UnsupportedEncodingException {
        return encode(s.getBytes("UTF-8"));
    }

    public static String encodeGbk(String s) throws UnsupportedEncodingException {
        return encode(s.getBytes("GBK"));
    }


    public static String decodeUtf8(String s) throws UnsupportedEncodingException {
        return decode(s, "UTF-8");
    }

    public static String decodeGbk(String s) throws UnsupportedEncodingException {
        return decode(s, "GBK");
    }

    public static String decode(String s, String charsetName) throws UnsupportedEncodingException {
        byte[] base64decodedBytes = Base64.getDecoder().decode(s);
        return new String(base64decodedBytes, charsetName);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String bs = "MDAwMk0wMjNNMDA0MlMwMXsiQUxJbmZvRXJyb3IiOnsiRGVzY3JpcHRpb24iOiLP+srbtaXD98+40MXPolvK/cG/Xda1WzBd0KHT2rXI09owIiwiU3VjZXNzIjoiMCIsIkNvZGUiOiJFRVIwMDAwMCJ9fQ==";

        System.out.println("=======================================");
        System.out.println("原文：");
        System.out.println(bs);
        System.out.println("=======================================");
        System.out.println("解密：");
        System.out.println(Base64Tool.decodeGbk(bs));
        System.out.println("=======================================");
        System.out.println("再加密：");
        System.out.println(Base64Tool.encodeGbk(Base64Tool.decodeGbk(bs)));
        System.out.println("=======================================");
    }
}
