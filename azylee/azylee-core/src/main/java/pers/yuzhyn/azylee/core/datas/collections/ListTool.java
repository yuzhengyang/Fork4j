package pers.yuzhyn.azylee.core.datas.collections;

import java.util.Collection;

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
}
