package com.yuzhyn.azylee.core.datas.strings;

import com.yuzhyn.azylee.core.datas.collections.ListTool;
import com.yuzhyn.azylee.core.logs.Alog;

import java.math.BigDecimal;
import java.util.*;

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

    /**
     * 开头字符计数
     * 如：开头有几个空格
     *
     * @param s  参数
     * @param ch 参数
     * @return 返回 返回
     */
    public static int startCharSize(String s, char ch) {
        int size = 0;
        for (char c : s.toCharArray()) {
            if (c == ch) {
                size++;
            } else {
                return size;
            }
        }
        return size;
    }

    /**
     * 缩进空格
     *
     * @param s    参数
     * @param size 参数
     * @return 返回 返回
     */
    public static String retractSpace(String s, int size) {
        if (ok(s)) {
            int startSpaceSize = startCharSize(s, ' ');
            if (startSpaceSize > 0 && startSpaceSize >= size) {
                return s.substring(size);
            } else {
                return s.substring(startSpaceSize);
            }
        }
        return "";
    }

    /**
     * 字符串分行
     *
     * @param s 参数
     * @return 返回 返回
     */
    public static String[] splitLine(String s) {
        if (ok(s)) {
            String[] lines = s.split("\\r?\\n");
            return lines;
        }
        return new String[]{""};
    }

    /**
     * 字符串拆分
     * 按照限制个数拆分，超出个数后，会使用合并连接符合并到最后一个字符串里
     *
     * @param s             待拆分字符串
     * @param regex         拆分规则
     * @param size          拆分个数限制
     * @param combineString 超过限制的合并连接符
     * @param filterSpace   过滤空格内容
     * @return 返回 返回
     */
    public static String[] splitLine(String s, String regex, int size, String combineString, boolean filterSpace) {
        String[] result = new String[size];
        if (ok(s)) {
            int pos = 0;
            String[] lines = s.split(regex);
            for (int i = 0; i < lines.length; i++) {
                lines[i] = lines[i].trim();
                boolean todo = true;
                if (filterSpace) {
                    todo = ok(lines[i]);
                }

                if (todo) {
                    if (ok(result[pos])) {
                        result[pos] += combineString;
                    } else {
                        result[pos] = "";
                    }
                    result[pos] += lines[i];
                    pos++;
                    if (pos >= size) pos = size - 1;
                }
            }
        }
        return result;
    }

    /**
     * 字符串拆分
     *
     * @param s            参数
     * @param regex        参数
     * @param filterSpace  参数
     * @param filterRepeat 参数
     * @return 返回 返回
     */
    public static String[] split(String s, String regex, boolean filterSpace, boolean filterRepeat) {
        if (ok(s)) {
            String[] array = s.split(regex);
            // 过滤空格
            List<String> list = new ArrayList<String>();
            Set<String> sets = new HashSet<String>();
            for (String item : array) {
                boolean canAdd = false;

                if (filterSpace) {
                    if (StringTool.ok(item.trim())) canAdd = true;
                } else {
                    canAdd = true;
                }

                if (canAdd) {
                    if (filterRepeat) {
                        if (!sets.contains(item)) {
                            list.add(item);
                            sets.add(item);
                        }
                    } else {
                        list.add(item);
                    }
                }
            }
            return list.toArray(new String[list.size()]);
        } else {
            return null;
        }
    }

    /**
     * 字符串数组合并
     *
     * @param lines      参数
     * @param joinString 参数
     * @return 返回 返回
     */
    public static String combineArray(String[] lines, String joinString) {
        if (ListTool.ok(lines)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < lines.length; i++) {
                stringBuilder.append(lines[i]);
                if (i < lines.length - 1) {
                    stringBuilder.append(joinString);
                }
            }
            return stringBuilder.toString();
        }
        return "";
    }

    /**
     * 缩进空格，按分行自动缩进，最后再组装为字符串
     *
     * @param s 参数
     * @return 返回 返回
     */
    public static String retractSpaceArrayAuto(String s) {
        int spaceSize = Integer.MAX_VALUE;
        String[] lines = splitLine(s);
        for (String line : lines) {
            if (ok(line)) {
                int size = startCharSize(line, ' ');
                if (size < spaceSize) spaceSize = size;
            }
        }
        for (int i = 0; i < lines.length; i++) {
            lines[i] = retractSpace(lines[i], spaceSize);
        }
        return combineArray(lines, StringConst.NEWLINE);
    }


    public static String replace(String inString, String oldPattern, String newPattern) {
        if (ok(inString) && ok(oldPattern) && newPattern != null) {
            int index = inString.indexOf(oldPattern);
            if (index == -1) {
                return inString;
            } else {
                int capacity = inString.length();
                if (newPattern.length() > oldPattern.length()) {
                    capacity += 16;
                }

                StringBuilder sb = new StringBuilder(capacity);
                int pos = 0;

                for (int patLen = oldPattern.length(); index >= 0; index = inString.indexOf(oldPattern, pos)) {
                    sb.append(inString, pos, index);
                    sb.append(newPattern);
                    pos = index + patLen;
                }

                sb.append(inString, pos, inString.length());
                return sb.toString();
            }
        } else {
            return inString;
        }
    }

    public String[] array2TreeArray(String[] array, String combineString) {
        String[] result = new String[array.length];

        return result;
    }


    /**
     * 从列表中，查询包含内容的项
     *
     * @param list  字符串列表
     * @param value 要匹配的内容（contains）
     * @return 返回 返回第一个匹配的索引下标
     */
    public static int itemLike(List<String> list, String value) {
        if (ListTool.ok(list)) {
            for (int i = 0; i < list.size(); i++) {
                if (StringTool.ok(list.get(i)) && list.get(i).contains(value)) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        String[] array = new String[]{"1", "3", "5"};
        String[] array1 = Arrays.copyOf(array, 0);
        String[] array2 = Arrays.copyOf(array, 1);


        BigDecimal num = new BigDecimal("1.5393");

        System.out.println(num);

//        Alog.i(">");
//        String[] rs = split(" 12 3 3 32 2 13     2 ", " ", true, true);
//        Alog.i(Arrays.asList(rs));
//        Alog.i("<");


//        String a = "1";
//        String b = null;
//        Alog.v("rs: " + StringTool.ok(a, b));
//
//        Alog.v(StringTool.reverse("12345"));
//
//
//        Alog.i("->   " + "456789".indexOf("456"));

        String x = "123";
        String y = "";

        Alog.i(StringTool.ok(x, y));
    }
}
