package pers.yuzhyn.azylee.core.datas.encrypts;

import pers.yuzhyn.azylee.core.logs.Alog;

public class HexTool {

    /**
     * 字符串 转 十六进制
     *
     * @param s
     * @return
     */
    public static String toHex(String s) {
        return HexTool.toHex(s.getBytes());
    }

    /**
     * 字节数组 转 十六进制
     *
     * @param b
     * @return
     */
    public static String toHex(byte[] b) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            result.append(String.format("%02X", b[i]));
        }
        return result.toString();
    }

    /**
     * 十六进制 转 字符串
     *
     * @param src
     * @param charset
     * @param toCharset
     * @return
     */
    public static String toString(String src, String charset, String toCharset) {
        byte[] bts = hex2Bytes(src);
        try {
            if (charset.equals(toCharset)) {
                return new String(bts, charset);
            } else {
                return new String(new String(bts, charset).getBytes(), toCharset);
            }
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 十六进制字符串 转 字节数组
     * @param src
     * @return
     */
    public static byte[] hex2Bytes(String src) {
        int l = src.length() / 2;
        byte[] ret = new byte[l];
        for (int i = 0; i < l; i++) {
            ret[i] = Integer.valueOf(src.substring(i * 2, i * 2 + 2), 16).byteValue();
        }
        return ret;
    }

    public static void main(String[] args) {
        String text = "此地无银三百两";
        Alog.i(HexTool.toHex(text));
//        Alog.i(HexTool.toString(text));
        Alog.i(HexTool.toString("E6ADA4E59CB0E697A0E993B6E4B889E799BEE4B8A4", "UTF-8", "UTF-8"));
    }
}
