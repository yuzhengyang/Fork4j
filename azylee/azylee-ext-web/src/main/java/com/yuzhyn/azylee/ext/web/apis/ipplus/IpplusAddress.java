package com.yuzhyn.azylee.ext.web.apis.ipplus;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class IpplusAddress {
    private static final String IP_URL = "https://www.ipplus360.com/getIP";
    private static final String IP_LOC = "https://www.ipplus360.com/getLocation";

    public static String getIp() {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(IP_URL).build();
            try (Response response = client.newCall(request).execute()) {
                JSONObject jsonObject = JSON.parseObject(response.body().string());
                return  jsonObject.getString("data");
            }
        } catch (IOException ex) {
        }
        return "";
    }

    public static String getIpLoc() {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(IP_LOC).build();
            try (Response response = client.newCall(request).execute()) {
                JSONObject jsonObject = JSON.parseObject(response.body().string());
                return  jsonObject.getString("data");
            }
        } catch (IOException ex) {
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(getIp());
        System.out.println(getIpLoc());
    }
}
