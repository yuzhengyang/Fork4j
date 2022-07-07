package com.yuzhyn.azylee.core.datas.objects;

/**
 * ObjectTool 糖
 */
public class Obj {

    /**
     * 空对象判断及默认值处理
     * @param obj 参数
     * @param defaultValue 参数
     * @param <T> 参数
     * @return 返回 返回
     */
    public static <T> T op(T obj, T defaultValue) {
        return ObjectTool.optional(obj, defaultValue);
    }

    public static void main(String[] args) {

    }
}
