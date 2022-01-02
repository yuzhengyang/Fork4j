package com.yuzhyn.azylee.core.datas.objects;

import java.util.Optional;

/**
 * Object 对象处理
 */
public class ObjectTool {

    /**
     * 空对象处理，简化代码
     * @param obj 参数
     * @param defaultValue 参数
     * @param <T> 参数
     * @return 返回
     */
    public static <T> T optional(T obj, T defaultValue) {
        try {
            Optional optional = Optional.ofNullable(obj);
            if (optional.isPresent()) return (T) optional.get();
        } catch (Exception ex) {
        }
        return defaultValue;

    }
}
