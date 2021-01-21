package pers.yuzhyn.azylee.core.datas.collections;

import pers.yuzhyn.azylee.core.logs.Alog;

import java.util.Map;
import java.util.Optional;

public class MapTool {

    public static boolean ok(Map map) {
        if (map != null && map.size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean ok(Map map, String... keys) {
        if (MapTool.ok(map)) {
            for (String key : keys) {
                if (map.getOrDefault(key, null) == null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static <K, T> T get(Map<K, T> map, K key, T defaultValue) {
        if (map.containsKey(key)) {
            return Optional.ofNullable(map.getOrDefault(key, defaultValue)).orElse(defaultValue);
        }
        return defaultValue;
    }

    public static void print(Map map) {
        Alog.w("maptool:print");
        if (ok(map)) {
            for (Object key : map.keySet()) {
                Alog.i(key + " = " + map.get(key));
            }
        } else {
            Alog.e("maptool:map is null");
        }
    }
}
