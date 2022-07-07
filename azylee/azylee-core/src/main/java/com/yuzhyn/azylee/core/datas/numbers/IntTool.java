package com.yuzhyn.azylee.core.datas.numbers;

import com.yuzhyn.azylee.core.datas.collections.ListTool;
import com.yuzhyn.azylee.core.datas.strings.StringFillTool;
import com.yuzhyn.azylee.core.logs.Alog;

import java.util.ArrayList;
import java.util.List;

public class IntTool {
    /**
     * 创建整数数组列表
     *
     * @param begin 从?开始（包含）
     * @param end   到?结束（包含）
     * @return 返回
     */
    public static List<Integer> createIntegerList(int begin, int end) {
        List<Integer> list = new ArrayList<>();
        int min = Math.min(begin, end);
        int max = Math.max(begin, end);
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return list;
    }

    public static int parse(String s, int defaultValue) {
        int num = defaultValue;
        try {
            num = Integer.parseInt(s);
        } catch (Exception ex) {
            Alog.e(ex.getMessage());
        }
        return num;
    }

    public static Integer parse(String s) {
        Integer num = null;
        try {
            num = Integer.parseInt(s);
        } catch (Exception ex) {
        }
        return num;
    }

    public static int[] convert(String[] array) {
        List<Integer> list = new ArrayList<>();
        if (ListTool.ok(array)) {
            for (String s : array) {
                Integer n = parse(s);
                if (n != null) {
                    list.add(n);
                }
            }
        }
        int[] integerArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            integerArray[i] = list.get(i);
        }
        return integerArray;
    }

    public static boolean inArray(int[] array, int number) {
        for (Integer item : array) {
            if (item == number) return true;
        }
        return false;
    }

    public static String toStr(int num, int length) {
        if (length < 1) length = 1;
        String s = String.valueOf(num);
        if (s.length() >= length) return s;
        return StringFillTool.prefixFill(s, length, "0");
    }

    public static void main(String[] args) {
//        System.out.println(IntTool.toStr(1, 2));
//        System.out.println(IntTool.toStr(1995, 2));
//        System.out.println(IntTool.parse("AB"));
//        System.out.println(IntTool.inArray(new int[]{1, 2, 3}, 2));
//        String[] array1 = new String[]{"05", "08", "12"};
//        int[] array2 = IntTool.convert(array1);
//        System.out.println(IntTool.inArray(array2, 12));

    }
}
