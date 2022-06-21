package com.yuzhyn.azylee.core.datas.collections;

import com.yuzhyn.azylee.core.datas.strings.StringTool;
import com.yuzhyn.azylee.core.logs.Alog;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ListTool {

    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    public static boolean ok(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean ok(Collection<?> collection1, Collection<?> collection2) {
        return !isEmpty(collection1) && !isEmpty(collection2);
    }

    public static boolean ok(Collection<?> collection1, Collection<?> collection2, Collection<?> collection3) {
        return !isEmpty(collection1) && !isEmpty(collection2) && !isEmpty(collection3);
    }

    public static boolean ok(Collection<?> collection1, Collection<?> collection2, Collection<?> collection3, Collection<?> collection4) {
        return !isEmpty(collection1) && !isEmpty(collection2) && !isEmpty(collection3) && !isEmpty(collection4);
    }

    public static boolean ok(Collection<?> collection1, Collection<?> collection2, Collection<?> collection3, Collection<?> collection4, Collection<?> collection5) {
        return !isEmpty(collection1) && !isEmpty(collection2) && !isEmpty(collection3) && !isEmpty(collection4) && !isEmpty(collection5);
    }

    public static boolean ok(byte[] bytes) {
        return bytes != null && bytes.length > 0;
    }

    public static <T> boolean ok(T[] array) {
        return array != null && array.length > 0;
    }

    public static <T> T get(List<T> collection, int index, T defaultValue) {
        if (ListTool.ok(collection) && collection.size() > index) {
            return collection.get(index);
        }
        return defaultValue;
    }


    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("1");
        List<String> list2 = null;
        Alog.v("list1 rs: " + ListTool.ok(list1));
        Alog.v("list2 rs: " + ListTool.ok(list2));

        Alog.v("lists : " + ListTool.ok(list1, list2));
    }
}
