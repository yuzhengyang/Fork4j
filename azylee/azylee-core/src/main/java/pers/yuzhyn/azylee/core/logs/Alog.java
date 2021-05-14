package pers.yuzhyn.azylee.core.logs;

import pers.yuzhyn.azylee.core.datas.collections.ListTool;
import pers.yuzhyn.azylee.core.datas.objects.ObjectTool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Alog {
    private static final String ARROW_SIGN = ">";

    public static void v() {
        v(ARROW_SIGN);
    }

    public static void v(String s) {
        System.out.format("\33[32;2m%s%n", s);
    }

    public static void i() {
        i(ARROW_SIGN);
    }

    public static void i(Object o) {
        System.out.format("\33[36;2m%s%n", o.toString());
    }

    public static void i(String s) {
        System.out.format("\33[36;2m%s%n", s);
    }

    public static void i(List<String> list) {
        if (ListTool.ok(list)) {
            for (String s : list) {
                i(s);
            }
        }
    }

    public static void w() {
        w(ARROW_SIGN);
    }

    public static void w(String s) {
        System.out.format("\33[33;2m%s%n", s);
    }

    public static void e() {
        e(ARROW_SIGN);
    }

    public static void e(String s) {
        System.out.format("\33[31;2m%s%n", s);
    }

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("sex", 1);
        map.put("sign", '6');
        map.put("age",15);
        Alog.i(map);
        System.out.println(map.toString());
    }
}
