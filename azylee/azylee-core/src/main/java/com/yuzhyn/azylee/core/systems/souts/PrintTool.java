package com.yuzhyn.azylee.core.systems.souts;

import com.yuzhyn.azylee.core.datas.collections.ListTool;

import java.util.List;

public class PrintTool {
    public static void out(List<String> lines) {
        if (ListTool.ok(lines)) {
            for (String line : lines) {
                System.out.println(line);
            }
        }
    }
}
