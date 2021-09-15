package com.yuzhyn.azylee.core.datas.collections;

public class ArrayTool {
    public static <T> T get(T[] array, int index, T defaultValue) {
        if (ListTool.ok(array) && array.length > index) {
            return array[index];
        }
        return defaultValue;
    }
}
