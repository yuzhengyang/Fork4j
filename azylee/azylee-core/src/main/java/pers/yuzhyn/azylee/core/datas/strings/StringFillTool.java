package pers.yuzhyn.azylee.core.datas.strings;

public class StringFillTool {

    public static String headFill(String s, int length, String filler) {
        String result = s;
        for (int i = 0; i < length - s.length(); i++) {
            result = filler + result;
        }
        return result;
    }

    public static void main(String[] args) {
        String name = "zhangfei";
        String nameFilled = headFill(name, 20, "_");

        System.out.println(name);
        System.out.println(nameFilled);
        System.out.println(nameFilled.length());
    }
}
