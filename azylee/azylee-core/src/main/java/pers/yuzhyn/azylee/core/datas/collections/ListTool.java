package pers.yuzhyn.azylee.core.datas.collections;

import pers.yuzhyn.azylee.core.datas.strings.StringTool;
import pers.yuzhyn.azylee.core.logs.Alog;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ListTool {

    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

//    public static boolean isEmpty(Collection<?>... collections) {
//        for (Collection c : collections) {
//            return (c == null || c.isEmpty());
//        }
//        return true;
//    }

    public static boolean ok(Collection<?> collection) {
        return !isEmpty(collection);
    }

//    public static boolean ok(Collection<?>... collection) {
//        return !isEmpty(collection);
//    }

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

    public static int itemLike(List<String> list, String value) {
        if (ListTool.ok(list)) {
            for (int i = 0; i < list.size(); i++) {
                if (StringTool.ok(list.get(i)) && list.get(i).contains(value)) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("1");
        List<String> list2 = null;
        Alog.v("list1 rs: " + ListTool.ok(list1));
        Alog.v("list2 rs: " + ListTool.ok(list2));
    }
}
