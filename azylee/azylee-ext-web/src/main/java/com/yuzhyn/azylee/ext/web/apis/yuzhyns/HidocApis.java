package com.yuzhyn.azylee.ext.web.apis.yuzhyns;

import com.alibaba.fastjson2.JSONObject;
import com.yuzhyn.azylee.core.datas.datetimes.DateTimeFormat;
import com.yuzhyn.azylee.core.datas.datetimes.DateTimeFormatPattern;
import com.yuzhyn.azylee.ext.web.https.HttpTool;
import okhttp3.*;

import java.io.IOException;
import java.time.LocalDateTime;

public class HidocApis {

    public static final String HIDOC_SERVER_API_HELLO = "https://www.yuzhyn.top/hidoc_server_api/openapi/app/hello";
    public static final String HIDOC_SERVER_API_TIMESTAMP = "https://www.yuzhyn.top/hidoc_server_api/openapi/app/timestamp";
    public static final String HIDOC_SERVER_API_DATACOLL_CREATE = "https://www.yuzhyn.top/hidoc_server_api/datacoll/create";

    /**
     * hidoc服务hello接口，可以获取应答
     */
    public static String hello() {
        return HttpTool.get(HIDOC_SERVER_API_HELLO);
    }

    /**
     * hidoc服务时间接口，可以获取时间戳
     */
    public static String timestamp() {
        return HttpTool.get(HIDOC_SERVER_API_TIMESTAMP);
    }


    public static void datacollCreate(String token, String dataSource, String senderId, String senderName, String senderMachine, String mac, JSONObject data) {
        String URL = "https://www.yuzhyn.top/hidoc_server_api/datacoll/create";
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("token", token);
            jsonObject.put("dataSource", dataSource);
            jsonObject.put("clientType", System.getProperty("os.name"));
            jsonObject.put("mac", mac);
            jsonObject.put("senderId", senderId);
            jsonObject.put("senderName", senderName);
            jsonObject.put("senderMachine", senderMachine);
            jsonObject.put("senderAccount", System.getProperty("user.name"));
            jsonObject.put("data", data.toJSONString());
            jsonObject.put("createTime", DateTimeFormat.toStr(LocalDateTime.now(), DateTimeFormatPattern.NORMAL_DATETIME));
            jsonObject.put("dataType", "azylee");

            OkHttpClient client = new OkHttpClient();
            MediaType JSON = MediaType.get("application/json; charset=utf-8");
            RequestBody body = RequestBody.create(jsonObject.toJSONString(), JSON);
            Request request = new Request.Builder()
                    .url(URL)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (Exception ex) {
        }
    }

}
