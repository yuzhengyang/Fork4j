package pers.yuzhyn.azylee.core.datas.collections;

import java.util.Map;
import java.util.Optional;

public class MapTool {

    public static <K, T> T get(Map<K, T> map, K key, T defaultValue) {
        if (map.containsKey(key)) {
            return Optional.ofNullable(map.getOrDefault(key, defaultValue)).orElse(defaultValue);
        }
        return defaultValue;
    }
}
