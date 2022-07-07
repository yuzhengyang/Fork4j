package com.yuzhyn.azylee.core.ios.txts;

import com.yuzhyn.azylee.core.ios.files.FileTool;
import com.yuzhyn.azylee.core.logs.Alog;
import com.yuzhyn.azylee.core.datas.collections.MapTool;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class PropertyTool {

    private static final String CHARSET_NAME = "utf-8";

    /**
     * 读取配置文件指定key的值
     *
     * @param pathName 参数
     * @param key 参数
     * @param defaultValue 参数
     * @return 返回 返回
     */
    public static String read(String pathName, String key, String defaultValue) {
        if (FileTool.isExist(pathName)) {
            try {
                Properties properties = new Properties();
                InputStream in = new BufferedInputStream(new FileInputStream(pathName));
                properties.load(new InputStreamReader(in, CHARSET_NAME));
                String value = properties.getProperty(key);
                return Optional.ofNullable(value).orElse(defaultValue);
            } catch (Exception ex) {
            }
        }
        return defaultValue;
    }

    /**
     * 读取配置文件所有配置项及值
     *
     * @param pathName 参数
     * @return 返回 返回
     */
    public static Map<String, String> read(String pathName) {
        Map<String, String> result = new HashMap<>(10);
        if (FileTool.isExist(pathName)) {
            try {
                Properties properties = new Properties();
                InputStream in = new BufferedInputStream(new FileInputStream(pathName));
                properties.load(new InputStreamReader(in, CHARSET_NAME));

                // 遍历配置项
                Enumeration<?> enumeration = properties.propertyNames();
                while (enumeration.hasMoreElements()) {
                    String name = (String) enumeration.nextElement();
                    String value = properties.getProperty(name);
                    result.put(name, value);
                }

//                //第二种方法遍历Properties:
//                //use KeySet to visit the properties
//                System.out.println("KeySet()");
//                Set<Object> keyset = properties.keySet();
//                Iterator<Object> itr = keyset.iterator();
//                while(itr.hasNext()){
//                    String key = (String) itr.next();
//                    System.out.println(key + "=" + properties.getProperty(key));
//                }
//
//                System.out.println();
//
//                //第三种方法遍历Properties:
//                //use stringPropertyNames()  to visit the properties
//                System.out.println("stringPropertyNames() ");
//                Set<String> keysetNew = properties.stringPropertyNames();
//                Iterator<String> itrNew = keysetNew.iterator();
//                while(itrNew.hasNext()){
//                    String key = itrNew.next();
//                    System.out.println(key + "=" + properties.getProperty(key));
//                }
            } catch (Exception ex) {
            }
        }
        return result;
    }

    public static boolean write(String pathName, Map<String, String> props )
    {
        return PropertyTool.write(pathName,props,"");
    }

    public static boolean write(String pathName, Map<String, String> props, String comments) {
        try {
            if (FileTool.create(pathName) && MapTool.ok(props)) {
                // 读取原文件配置值
                Properties properties = new Properties();
                InputStream in = new BufferedInputStream(new FileInputStream(pathName));
                properties.load(new InputStreamReader(in, CHARSET_NAME));

                // 写出配置
                File file = new File(pathName);
                OutputStream outputStream = new FileOutputStream(file);
                for (String key : props.keySet()) {
                    properties.put(key, props.get(key));
                }
                properties.store(new OutputStreamWriter(outputStream, CHARSET_NAME), comments);
                return true;
            }
        } catch (Exception ex) {
            Alog.e(ex.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        /**
         * name=zhangsanfeng
         * age=100
         * dept=wudang
         * so=
         */
        String config = "d:\\temp\\config.properties";
        Alog.i("[" + PropertyTool.read(config, "name", "无名氏") + "]");
        Alog.i("[" + PropertyTool.read(config, "age", "保密") + "]");
        Alog.i("[" + PropertyTool.read(config, "dept", "江湖侠客") + "]");
        Alog.i("[" + PropertyTool.read(config, "so", "...") + "]");
        Alog.i("[" + PropertyTool.read(config, "power", "...") + "]");
        Alog.e();
        Alog.e();
        Map props = PropertyTool.read(config);
        MapTool.print(props);
        Alog.e();
        Alog.e();
        Map<String, String> pms = new HashMap<>();
        pms.put("age", LocalDateTime.now().getSecond() + "");
        pms.put("car", "自行车");
        boolean writeFlag = PropertyTool.write(config, pms);
        Alog.i("writeFlag: " + writeFlag);
    }
}
