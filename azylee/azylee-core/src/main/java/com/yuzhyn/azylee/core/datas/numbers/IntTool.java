package com.yuzhyn.azylee.core.datas.numbers;

import com.yuzhyn.azylee.core.datas.strings.StringFillTool;
import com.yuzhyn.azylee.core.logs.Alog;

public class IntTool {
    public static int parse(String s, int defaultValue) {
        int num = defaultValue;
        try {
            num = Integer.parseInt(s);
        } catch (Exception ex) {
            Alog.e(ex.getMessage());
        }
        return num;
    }

    public static String toStr(int num, int length) {
        if (length < 1) length = 1;
        String s = String.valueOf(num);
        if (s.length() >= length) return s;
        return StringFillTool.prefixFill(s, length, "0");
    }

    public static void main(String[] args) {
        System.out.println(IntTool.toStr(1, 2));
        System.out.println(IntTool.toStr(1995, 2));
    }
}
