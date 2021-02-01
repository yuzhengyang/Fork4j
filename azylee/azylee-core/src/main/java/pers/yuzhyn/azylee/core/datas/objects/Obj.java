package pers.yuzhyn.azylee.core.datas.objects;

import java.util.Optional;

/**
 * ObjectTool 糖
 */
public class Obj {

    /**
     * 空对象判断及默认值处理
     * @param obj
     * @param defaultValue
     * @param <T>
     * @return
     */
    public static <T> T op(T obj, T defaultValue) {
        return ObjectTool.optional(obj, defaultValue);
    }

    public static void main(String[] args) {

    }
}
