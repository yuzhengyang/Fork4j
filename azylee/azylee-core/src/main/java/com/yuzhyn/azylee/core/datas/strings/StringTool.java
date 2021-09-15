package com.yuzhyn.azylee.core.datas.strings;

import com.yuzhyn.azylee.core.logs.Alog;

public class StringTool {
    public static boolean ok(String s) {
        if (s != null && s.length() > 0) {
            return true;
        }
        return false;
    }

    public static boolean ok(String... strings) {
        for (String s : strings) {
            if (!ok(s)) {
                return false;
            }
        }
        return true;
    }

    public static boolean has(String s, String... words) {
        for (String word : words) {
            if (!s.contains(word)) {
                return false;
            }
        }
        return true;
    }

    public static String reverse(String s) {
        if (null == s) return "";

        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String a = "1";
        String b = null;
        Alog.v("rs: " + StringTool.ok(a, b));

        Alog.v(StringTool.reverse("12345"));


        Alog.i("->   " + "456789".indexOf("456"));
    }
}
