package com.yuzhyn.azylee.core.reflects.bases;

import com.yuzhyn.azylee.core.datas.collections.ListTool;
import com.yuzhyn.azylee.core.datas.strings.NameFormat;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodTool {

    public static final String GETTER_PREFIX = "get";

    public static List<Method> getterWithoutParams(Method[] methods) {
        List<Method> resultList = new ArrayList<>();
        if (ListTool.ok(methods)) {
            for (Method item : methods) {
                if (item.getName().startsWith(GETTER_PREFIX)) {
                    if (item.getParameters() == null || item.getParameters().length == 0) {
                        resultList.add(item);
                    }
                }
            }
        }
        return resultList;
    }
}
