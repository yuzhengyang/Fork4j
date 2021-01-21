package pers.yuzhyn.azylee.core.datas.uuids;

import java.util.UUID;

public class UUIDTool {

    public static UUID getUUID() {
        return UUID.randomUUID();
    }

    public static String getId() {
        return UUID.randomUUID().toString();
    }

    public static String get() {
        String s = getId();
        s = s.replace("-", "");
        return s;
    }

//    public static void main(String[] args) {
//        System.out.println(get());
//        System.out.println(getShort());
//    }
}
