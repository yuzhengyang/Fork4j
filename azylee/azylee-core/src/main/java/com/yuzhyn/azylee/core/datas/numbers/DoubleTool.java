package com.yuzhyn.azylee.core.datas.numbers;

import com.yuzhyn.azylee.core.logs.Alog;

public class DoubleTool {
    public static double parse(String s, double defaultValue) {
        double num = defaultValue;
        try {
            num = Double.parseDouble(s);
        } catch (Exception ex) {
            Alog.e(ex.getMessage());
        }
        return num;
    }
}
