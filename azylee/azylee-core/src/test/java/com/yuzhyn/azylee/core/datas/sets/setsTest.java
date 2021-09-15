package com.yuzhyn.azylee.core.datas.sets;

import java.util.HashSet;
import java.util.Set;

public class setsTest {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("张三丰");
        stringSet.add("张三丰");
        stringSet.add("张翠山");
        stringSet.add("张无忌");

        System.out.println(stringSet);
    }
}
