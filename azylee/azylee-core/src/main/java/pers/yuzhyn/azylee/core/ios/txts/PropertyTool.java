package pers.yuzhyn.azylee.core.ios.txts;

import pers.yuzhyn.azylee.core.ios.files.FileTool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;
import java.util.Properties;

public class PropertyTool {

    public static String read(String pathName, String key, String defaultValue) {
        if (FileTool.isExist(pathName)) {
            try {
                Properties properties = new Properties();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(pathName));
                properties.load(bufferedReader);
                String value = properties.getProperty(key);
                return Optional.ofNullable(value).orElse(defaultValue);
            } catch (Exception ex) {
            }
        }
        return defaultValue;
    }

//    public static void main(String[] args) {
//        /**
//         * name=zhangsanfeng
//         * age=100
//         * dept=wudang
//         * so=
//         */
//        String config = "d:\\tmp\\config.properties";
//        System.out.println(PropertyTool.read(config, "name", "无名氏"));
//        System.out.println(PropertyTool.read(config, "age", "保密"));
//        System.out.println(PropertyTool.read(config, "dept", "江湖侠客"));
//        System.out.println(PropertyTool.read(config, "so", "..."));
//        System.out.println(PropertyTool.read(config, "power", "..."));
//    }
}
