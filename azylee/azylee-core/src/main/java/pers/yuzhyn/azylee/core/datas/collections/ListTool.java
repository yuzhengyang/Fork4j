package pers.yuzhyn.azylee.core.datas.collections;

import java.util.Collection;
import java.util.List;

public class ListTool {

    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    public static boolean ok(Collection<?> collection) {
        return !isEmpty(collection);
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
}
