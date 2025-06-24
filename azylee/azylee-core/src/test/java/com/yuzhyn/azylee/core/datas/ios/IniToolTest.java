package com.yuzhyn.azylee.core.datas.ios;

import com.yuzhyn.azylee.core.ios.txts.IniTool;

public class IniToolTest {

    public static void main(String[] args) {
        String filePath = "D:\\temp\\bootstrap.ini";
        String name = IniTool.read(filePath, "app", "name", "");
        String version = IniTool.read(filePath, "app", "version", "");
        String ready = IniTool.read(filePath, "version", "ready", "66");

        System.out.println("write");
        System.out.println(IniTool.write(filePath, "version", "ready", "0"));
        System.out.println(IniTool.write(filePath, "app", "ready", "71"));

        System.out.println("------");
        System.out.println(name);
        System.out.println(version);
        System.out.println(ready);
    }
}
