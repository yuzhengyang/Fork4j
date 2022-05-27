package com.yuzhyn.azylee.core.datas.strings;

public class NameFormat {

    public static String underscore2Camel(String s) {
        String result = "";
        if (StringTool.ok(s)) {
            if (s.contains("_")) {
                boolean upFlag = false;
                char[] cArray = s.toCharArray();
                for (char c : cArray) {
                    if (c == '_') {
                        upFlag = true;
                        continue;
                    }

                    if (upFlag) {
                        result += (c + "").toUpperCase();
                        upFlag = false;
                    } else {
                        result += (c + "").toLowerCase();
                    }
                }
            } else {
                result = s.toLowerCase();
            }
        }
        return result;
    }

    public static String camel2Underscore(String name) {
        StringBuilder result = new StringBuilder();
        if (name != null && name.length() > 0) {
            result.append(name.substring(0, 1).toLowerCase());
            // 循环处理其余字符
            for (int i = 1; i < name.length(); i++) {
                String s = name.substring(i, i + 1);
                // 在大写字母前添加下划线
                if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
                    result.append("_");
                }
                // 其他字符接转成大写
                result.append(s.toLowerCase());
            }
        }
        return result.toString();
    }

    public static String firstCharToLower(String name) {
        StringBuilder result = new StringBuilder();
        if (name != null && name.length() > 0) {
            // 循环处理字符
            for (int i = 0; i < name.length(); i++) {
                String s = name.substring(i, i + 1);
                if (i == 0) s = s.toLowerCase();
                result.append(s);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(firstCharToLower("zhangWuJi"));
        System.out.println(firstCharToLower("ZhouZhiRuo"));
    }
}
