package pers.yuzhyn.azylee.core.datas.strings;

import pers.yuzhyn.azylee.core.logs.Alog;

public class StringFillTool {

    /**
     * 前缀补充字符
     *
     * @param s
     * @param length
     * @param filler
     * @return
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
     * @param s
     * @param length
     * @param filler
     * @return
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
    }
}
