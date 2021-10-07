package com.yuzhyn.azylee.core.datas.ids;

import java.util.UUID;

public class UUIDTool {

    public static UUID getUUID() {
        return UUID.randomUUID();
    }

    public static String getId() {
        return UUID.randomUUID().toString();
    }

    public static String get() {
        String s = getId();
        s = s.replace("-", "");
        return s;
    }

    public static String getId64() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(get());
        stringBuilder.append(get());
        return stringBuilder.toString();
    }

    public static String getId256() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(get());
        stringBuilder.append(get());
        stringBuilder.append(get());
        stringBuilder.append(get());
        stringBuilder.append(get());
        stringBuilder.append(get());
        stringBuilder.append(get());
        stringBuilder.append(get());
        return stringBuilder.toString();
    }

    public static String getId1024() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getId256());
        stringBuilder.append(getId256());
        stringBuilder.append(getId256());
        stringBuilder.append(getId256());
        return stringBuilder.toString();
    }

    public static String getId(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(getId1024());
        }
        return stringBuilder.toString();
    }

//    public static void main(String[] args) {
//        System.out.println(get());
//        System.out.println(getShort());
//    }
}
