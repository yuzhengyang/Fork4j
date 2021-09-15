package com.yuzhyn.azylee.core.datas.numbers;

import com.yuzhyn.azylee.core.logs.Alog;

public class LongTool {
    public static long parse(String s, long defaultValue) {
        long num = defaultValue;
        try {
            num = Long.parseLong(s);
        } catch (Exception ex) {
            Alog.e(ex.getMessage());
        }
        return num;
    }

    /**
     * 从int字符串转换为long数值
     * 特殊目的：强制降低转换精度，防止long计算溢出
     * @param s
     * @param defaultValue
     * @return
     */
    public static long parseFromInts(String s, long defaultValue) {
        int num = IntTool.parse(s, (int) defaultValue);
        return num;
    }
}
