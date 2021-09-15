package com.yuzhyn.azylee.core.reflects.bases;

import com.yuzhyn.azylee.core.reflects.models.ClassInfo;
import com.yuzhyn.azylee.core.reflects.models.FieldInfo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectTool {

    public static List<ClassInfo> reflect(Object... os) {
        List<ClassInfo> result = new ArrayList<>();
        for (Object o : os) {
            result.add(reflect(o));
        }
        return result;
    }

    public static ClassInfo reflect(Object o) {
        ClassInfo classInfo = new ClassInfo();
        List<FieldInfo> fieldInfoList = new ArrayList<>();
        //获取参数类
        Class cls = o.getClass();
        classInfo.setClassName(cls.getName());
        classInfo.setSimpleName(cls.getSimpleName());
        //将参数类转换为对应属性数量的Field类型数组（即该类有多少个属性字段 N 转换后的数组长度即为 N）
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);
            try {
                //f.getName()得到对应字段的属性名，f.get(o)得到对应字段属性值,f.getGenericType()得到对应字段的类型
//                System.out.println("属性名：" + f.getName() + "；属性值：" + f.get(o) + ";字段类型：" + f.getGenericType() + " , " + f.getGenericType().getTypeName());

                FieldInfo info = new FieldInfo();
                info.setName(f.getName());
                info.setType(f.getGenericType().getTypeName());
                fieldInfoList.add(info);
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        classInfo.setFieldInfoList(fieldInfoList);
        return classInfo ;
    }

    public static void main(String[] args) {
//        StudentMo s = new StudentMo();
//        s.setName("张三");
//        s.setAge(12);
//        reflect(s);
        ClassInfo infoList = reflect(new StudentMo());
        int a = 0;
    }
}
