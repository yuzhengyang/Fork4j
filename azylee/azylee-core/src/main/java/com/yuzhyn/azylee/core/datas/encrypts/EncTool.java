package com.yuzhyn.azylee.core.datas.encrypts;

import com.yuzhyn.azylee.core.datas.strings.StringConst;

public class EncTool {

    public static String enc(String text, String key) {
        if (!text.startsWith(StringConst.ENC_FLAG)) {
            return StringConst.ENC_FLAG + DesTool.encrypt(text, Md5Tool.encrypt(key));
        }
        return text;
    }

    public static String dec(String text, String key) {
        if (text.startsWith(StringConst.ENC_FLAG)) {
            String realText = text.substring(StringConst.ENC_FLAG.length());
            return DesTool.decrypt(realText, Md5Tool.encrypt(key));
        }
        return text;
    }

    public static void main(String[] args) {
        String text = "朝辞白帝彩云间";
        String enc1 = EncTool.enc(text, "234");
        System.out.println(enc1);
        String dec1 = EncTool.dec(enc1, "234");
        System.out.println(dec1);
    }
}
