package com.yuzhyn.azylee.core.datas.keyvalues;

import com.yuzhyn.azylee.core.datas.collections.ArrayTool;
import com.yuzhyn.azylee.core.datas.collections.ListTool;
import com.yuzhyn.azylee.core.datas.objects.ObjectTool;
import com.yuzhyn.azylee.core.datas.strings.StringTool;

import java.util.HashMap;
import java.util.Map;

/**
 * 键值对模型包，快捷获取相应类型的值
 * #场景 支持字符串键值解析与获取值，字符串格式：key:value,key2:value2,key3:value3
 */
public class KeyValueBag {
    private Map<String, Object> map;

    public KeyValueBag(String s) {
        this.map = new HashMap<>();
        if (StringTool.ok(s)) {
            // 兼容处理中英文逗号[，]和中英文分号[；]
            s = s.replaceAll(";", ",");
            s = s.replaceAll("，", ",");
            s = s.replaceAll("；", ",");

            String[] keyValues = StringTool.split(s, ",", true, true, true);
            if (ListTool.ok(keyValues)) {
                for (String item : keyValues) {
                    String[] pair = StringTool.splitLine(item, ":", 2, "", false);
                    String key = ArrayTool.get(pair, 0, "");
                    String val = ArrayTool.get(pair, 1, "");
                    map.put(key, val);
                }
            }
        }
    }

    public String getString(String key) {
        return ObjectTool.optional(map.get(key), "").toString();
    }

    public boolean getBool(String key) {
        String value = this.getString(key).toLowerCase();
        switch (value) {
            case "1":
            case "y":
            case "true":
            case "yes":
            case "enable":
            case "visible":
                return true;
            default:
                return false;
        }
    }

    public void print() {
        for (String key : map.keySet()) {
            System.out.println("[" + key + "] : [" + map.get(key) + "]");
        }
    }

    public static void main(String[] args) {
//        KeyValuePair extOptions = new KeyValuePair("isOpen:1,isVip:0,isBlack:1,name:zhangsan,user,age:18,,");

        KeyValueBag extOptions = new KeyValueBag("  isOpen  :1 ,   isOpen  :2 ,   isOpen  :tu");

        extOptions.print();

        System.out.println("[isOpen] : [" + extOptions.getBool("isOpen") + "]");
    }
}
