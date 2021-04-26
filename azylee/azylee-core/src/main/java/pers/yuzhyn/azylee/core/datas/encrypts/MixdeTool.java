package pers.yuzhyn.azylee.core.datas.encrypts;

import pers.yuzhyn.azylee.core.datas.strings.StringTool;
import pers.yuzhyn.azylee.core.logs.Alog;

public class MixdeTool {

    /**
     * 混合拼接
     * 说明：字符串正序和倒序混合
     * 长度：64位
     *
     * @param s
     * @return
     */
    public static String md5Mix(String s) {
        String rs1 = Md5Tool.encrypt(s);
        String rs2 = Md5Tool.encrypt(StringTool.reverse(s));
        String rs = StringTool.reverse(rs1) + StringTool.reverse(rs2);
        return Md5Tool.encrypt(rs) + Md5Tool.encryptTwice(rs);
    }

    public static String md5Mix(String s1, String s2) {
        String rs1 = Md5Tool.encrypt(s1);
        String rs2 = Md5Tool.encrypt(s2);
        String rs = rs1 + StringTool.reverse(rs2);
        return Md5Tool.encrypt(rs) + Md5Tool.encryptTwice(rs);
    }

    /**
     * 逐个md5编码并最终混合拼接
     * 说明：循环临时编码较大
     * 长度：64位
     *
     * @param s
     * @return
     */
    public static String md5BigMix(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            String _m = Md5Tool.encrypt(String.valueOf(c));
            stringBuilder.append(_m);
        }
        return Md5Tool.encrypt(stringBuilder.toString()) + Md5Tool.encryptTwice(stringBuilder.toString());
    }

    public static void main(String[] args) {
        Alog.i(MixdeTool.md5Mix("胡天八月即飞雪"));
        Alog.i(MixdeTool.md5BigMix("胡天八月即飞雪"));
    }
}
