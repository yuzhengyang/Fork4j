package pers.yuzhyn.azylee.core.datas.collections;

import java.util.Collection;

public class ListUtil {

    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    public static boolean ok(Collection<?> collection) {
        return !isEmpty(collection);
    }
}
