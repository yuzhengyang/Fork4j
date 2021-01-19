package pers.yuzhyn.azylee.core.datas.numbers;

import pers.yuzhyn.azylee.core.logs.Alog;

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
}
