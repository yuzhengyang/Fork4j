package com.yuzhyn.azylee.core.datas.encrypts;

import java.net.URLDecoder;
import java.util.Base64;

public class JsDecodeTool {

    /**
     * web前端解码
     * 前端方法：window.btoa(encodeURIComponent(value));
     * @param value
     * @return
     */
    public String decode(String value) {
        try {
            return URLDecoder.decode(Base64Tool.decodeUtf8(value), "UTF-8");
        } catch (Exception ex) {
        }
        return "";
    }
}
