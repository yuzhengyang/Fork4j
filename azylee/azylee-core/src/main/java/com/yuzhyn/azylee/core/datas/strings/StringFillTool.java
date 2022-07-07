package com.yuzhyn.azylee.core.datas.strings;

import com.yuzhyn.azylee.core.logs.Alog;

public class StringFillTool {

    /**
     * 前缀补充字符
     *
     * @param s 参数
     * @param length 参数
     * @param filler 参数
     * @return 返回 返回
     */
    public static String prefixFill(String s, int length, String filler) {
        String result = s;
        for (int i = 0; i < length - s.length(); i++) {
            result = filler + result;
        }
        return result;
    }

    /**
     * 后缀补充字符
     *
     * @param s 参数
     * @param length 参数
     * @param filler 参数
     * @return 返回 返回
     */
    public static String suffixFill(String s, int length, String filler) {
        String result = s;
        for (int i = 0; i < length - s.length(); i++) {
            result = result + filler;
        }
        return result;
    }

    public static void main(String[] args) {
        {
            String name = "zhangfei";
            String nameFilled = prefixFill(name, 20, "_");
            Alog.e(name);
            Alog.e(nameFilled);
            Alog.e(nameFilled.length() + "");
        }
        {
            String name = "zhangfei";
            String nameFilled = suffixFill(name, 20, "_");
            Alog.e(name);
            Alog.e(nameFilled);
            Alog.e(nameFilled.length() + "");
        }
        {
            Alog.e("------");
            Alog.e(prefixFill("1", 2, "0"));
        }
    }
}
