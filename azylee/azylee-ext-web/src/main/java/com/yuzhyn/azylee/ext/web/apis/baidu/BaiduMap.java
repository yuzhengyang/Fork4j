package com.yuzhyn.azylee.ext.web.apis.baidu;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class BaiduMap {
    private static final String MAP_URL = "http://map.baidu.com/?qt=ipLocation";
//    public static String getTimeStampJson() {
//        try {
//            OkHttpClient client = new OkHttpClient();
//            Request request = new Request.Builder().url(MAP_URL).build();
//            try (Response response = client.newCall(request).execute()) {
//                return response.body().string();
//            }
//        } catch (IOException ex) {
//        }
//        return "";
//    }
//
//    public static void main(String[] args) {
//        System.out.println(getTimeStampJson());
//    }
}
