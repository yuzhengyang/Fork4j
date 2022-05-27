package com.yuzhyn.azylee.core.datas.collections;

import com.yuzhyn.azylee.core.datas.datetimes.LocalDateTimeTool;
import com.yuzhyn.azylee.core.datas.numbers.DoubleTool;
import com.yuzhyn.azylee.core.datas.numbers.IntTool;
import com.yuzhyn.azylee.core.datas.numbers.LongTool;
import com.yuzhyn.azylee.core.logs.Alog;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MapTool {

    /**
     * 判断 Map 存在至少一个元素
     *
     * @param map 参数
     * @return 返回
     */
    public static boolean ok(Map map) {
        if (map != null && map.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断 Map 中存在指定 Keys，且指定的 Keys 值不为 Null
     *
     * @param map  参数
     * @param keys 参数
     * @return 返回
     */
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

    public static <K, T> String getString(Map<K, T> map, K key, T defaultValue) {
        if (map.containsKey(key)) {
            return Optional.ofNullable(map.getOrDefault(key, defaultValue)).orElse(defaultValue).toString();
        }
        return defaultValue.toString();
    }

    public static <K, T> int getInt(Map<K, T> map, K key, T defaultValue) {
        String s = MapTool.getString(map, key, defaultValue);
        return IntTool.parse(s, IntTool.parse(defaultValue.toString(), 0));
    }

    public static <K, T> long getLong(Map<K, T> map, K key, T defaultValue) {
        String s = MapTool.getString(map, key, defaultValue);
        return LongTool.parse(s, LongTool.parse(defaultValue.toString(), 0));
    }

    public static <K, T> double getDouble(Map<K, T> map, K key, T defaultValue) {
        String s = MapTool.getString(map, key, defaultValue);
        return DoubleTool.parse(s, DoubleTool.parse(defaultValue.toString(), 0.0));
    }

    public static <K, T> boolean getBoolean(Map<K, T> map, K key, T defaultValue) {
        String s = MapTool.getString(map, key, defaultValue);
        return Boolean.valueOf(s);
    }

    public static <K, T> LocalDateTime getLocalDateTime(Map<K, T> map, K key, T defaultValue) {
        String s = MapTool.getString(map, key, null);
        LocalDateTime time = LocalDateTimeTool.parse(s);
        if (time != null) return time;
        return null;
    }

    /**
     * 抽取Map列表中的key值数据列表
     *
     * @param mapList 参数
     * @param key     参数
     * @param <K>     参数
     * @param <T>     参数
     * @return 返回
     */
    public static <K, T> List<T> extract(List<Map<K, T>> mapList, K key) {
        List<T> result = new ArrayList<>();
        if (ListTool.ok(mapList)) {
            for (Map<K, T> map : mapList) {
                if (ok(map)) {
                    result.add(get(map, key, null));
                }
            }
        }
        return result;
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
