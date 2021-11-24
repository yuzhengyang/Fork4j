package com.yuzhyn.azylee.core.datas.strings;

import com.yuzhyn.azylee.core.datas.collections.ListTool;
import com.yuzhyn.azylee.core.logs.Alog;

public class HtmlStringTool {
    public static String keywordsHightLight(String text, String keywords, String begTag, String endTag) {
        if (StringTool.ok(text)) {
            StringBuilder stringBuilder = new StringBuilder(text);
            String[] keywordArray = StringTool.split(keywords, " ", true, true);
            if (ListTool.ok(keywordArray)) {
                for (String key : keywordArray) {
                    int pos = 0;
                    pos = stringBuilder.indexOf(key, pos);
                    while (pos >= 0) {
                        String repText = begTag + key + endTag;
                        stringBuilder.replace(pos, pos + key.length(), repText);
                        pos += repText.length();
                        pos = stringBuilder.indexOf(key, pos);
                    }
                }
                return stringBuilder.toString();
            }
        }
        return "";
    }

    public static String newLineBrFotmat(String s) {
        if (StringTool.ok(s)) {
            String[] strings = StringTool.splitLine(s);
            return StringTool.combineArray(strings, "<br />");
        }
        return "";
    }

    public static void main(String[] args) {

        String keywords = "张三 哪 买 什";
        String s = "张三 李四 王五 去赶集 上哪去  去买什么，买点鸡蛋";
        String begTag = "<span style='color:red;'>";
        String endTag = "</span>";

        Alog.i(keywordsHightLight(s, keywords, begTag, endTag));
    }
}
