package com.yuzhyn.azylee.core.datas.regexs;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTool {

    /**
     * 获取字符串中匹配的所有内容
     *
     * @param str 字符串内容
     * @param reg 正则表达式
     * @return 返回
     */
    public static List<String> getMatchs(String str, String reg) {
        List<String> resultList = new ArrayList<>();

        Pattern patten = Pattern.compile(reg);//编译正则表达式
        Matcher matcher = patten.matcher(str);// 指定要匹配的字符串

        //此处find（）每次被调用后，会偏移到下一个匹配
        while (matcher.find()) {
            //获取当前匹配的值
            resultList.add(matcher.group());
        }
        return resultList;
    }

    public static void main(String[] args) {
        if (1 == 2) {
            String str = "select * from order where createdUser = ${currentUser} and  depart = ${currentOrg} and status = 'VALID'";
            String reg = "\\$\\{[a-zA-Z0-9]+\\}";

            for (String item : RegexTool.getMatchs(str, reg)) {
                System.out.println(item);
            }
        }

        if (3== 2) {
            String str = "select * from order where createdUser =" +
                    "[\uD83E\uDDF0 工具软件-数据库工具：DBeaver](/collected/121981462344892416/121983064824872960)\n" +
                    "[\uD83E\uDDF0 工具软件-数据库工具：DBeaver](#hd.ilink->121981462344892416/121983064824872960) 航安" +
                    "[\uD83E\uDDF0 工具软件-数据库工具：DBeaver](#hd.ilink->121981462344892416/121983064824872960)" +
                    "[\uD83E\uDDF0 工具软件-数据库工具：DBeaver](#hd.ilink->121981462344892416/121983064824872960) 6666" +
                    "[\uD83E\uDDF0 工具软件-数据库工具：DBeaver](#hd.ilink->121981462344892416/121983064824872960)" +
                    " $(#hd.ilink->current/User) and  depart = $(#hd.ilink->current/Org) and status = 'VALID'";
            String reg = "\\(#hd\\.ilink->[a-zA-Z0-9/]+\\)";

            for (String item : RegexTool.getMatchs(str, reg)) {
                System.out.println(item);
            }
        }
        System.out.println("-----------------------------------------------");

        if (2 == 2) {
            String str = "[\uD83E\uDDF0 工具软件](http://192.168.14.61:8080/collected/121981462344892416/121983064824872960)\n" +
                    "\n" +
                    "[\uD83E\uDDF0 工具软件-数据库工具：DBeaver](/collected/121981462344892416/121983064824872960)\n" +
                    "[\uD83E\uDDF0 工具软件-数据库工具：DBeaver](#hd.ilink->121981462344892416/121983064824872960) 航安" +
                    "[\uD83E\uDDF0 工具软件-数据库工具：DBeaver](#hd.ilink->121981462344892416/121983064824872960)" +
                    "[\uD83E\uDDF0 工具软件-数据库工具：DBeaver](#hd.ilink->121981462344892416/121983064824872960) 6666" +
                    "[\uD83E\uDDF0 工具软件-数据库工具：DBeaver](#hd.ilink->121981462344892416/121983064824872960)" +
                    "<p>萌萌萌~</p>\n" +
                    "\n" +
                    "![图片](#hd.image->172747242271145984.jpg)\n" +
                    "\n" +
                    "\n" +
                    "![图片](#hd.image->172840232721317888.png)";

            String reg = "\\[.*?\\]\\(#hd\\.ilink->.*?\\)";

            for (String item : RegexTool.getMatchs(str, reg)) {
                System.out.println(item);
                System.out.println("");
            }
        }
    }
}
