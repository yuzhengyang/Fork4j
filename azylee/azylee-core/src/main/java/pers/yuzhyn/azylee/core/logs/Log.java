package pers.yuzhyn.azylee.core.logs;

public class Log {
    public static void v(String s) {
        System.out.format("\33[32;2m%s%n",s);
    }

    public static void i(String s) {
        System.out.format("\33[36;2m%s%n",s);
    }

    public static void w(String s) {
        System.out.format("\33[33;2m%s%n",s);
    }

    public static void e(String s) {
        System.out.format("\33[31;2m%s%n",s);
    }
}
