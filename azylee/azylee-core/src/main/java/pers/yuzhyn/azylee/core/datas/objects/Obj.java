package pers.yuzhyn.azylee.core.datas.objects;

import java.util.Optional;

/**
 * ObjectTool 糖
 */
public class Obj {

    /**
     * 空对象判断及默认值处理
     * @param obj
     * @param dftVal
     * @param <T>
     * @return
     */
    public static <T> T op(T obj, T dftVal) {
        return ObjectTool.optional(obj, dftVal);
    }

    public static void main(String[] args) {

    }
}
