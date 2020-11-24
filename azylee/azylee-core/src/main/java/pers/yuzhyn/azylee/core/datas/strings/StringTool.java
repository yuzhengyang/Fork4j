package pers.yuzhyn.azylee.core.datas.strings;

public class StringTool {
    public static boolean ok(String s) {
        if (s != null && s.length() > 0) {
            return true;
        }
        return false;
    }

    public static boolean ok(String... strings) {
        for (String s : strings) {
            if (!ok(s)) {
                return false;
            }
        }
        return true;
    }
}
