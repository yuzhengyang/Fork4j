package com.yuzhyn.azylee.websdk.model.trans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseData {
    private String token;
    private String msg;
    private int code;
    private long count;
    private Map<String, Object> meta = new HashMap();
    private List data = new ArrayList();
    private Integer popUp;


    public ResponseData() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getPopUp() {
        return this.popUp;
    }

    public void setPopUp(Integer popUp) {
        this.popUp = popUp;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getCode() {
        return this.code;
    }

    public long getCount() {
        return this.count;
    }

    public Map<String, Object> getMeta() {
        return this.meta;
    }

    public List<Object> getData() {
        return this.data;
    }

    public ResponseData putDataMap(String key, Object value) {
        this.meta.put(key, value);
        return this;
    }

    public ResponseData putData(List value) {
        this.data.addAll(value);
        return this;
    }

    public ResponseData changeMap(Map<String, Object> map) {
        this.meta = map;
        return this;
    }

    public ResponseData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ResponseData(int code, String msg, long count) {
        this.code = code;
        this.msg = msg;
        this.count = count;
    }

    public static ResponseData rpcResponse(int code, String msg) {
        return new ResponseData(code, msg);
    }

    public static ResponseData ok() {
        return new ResponseData(0, "Ok");
    }

    public static ResponseData error() {
        return new ResponseData(1, "ERROR");
    }

    public static ResponseData exist() {
        return new ResponseData(2, "tip");
    }

    public static ResponseData ok(String msg) {
        return new ResponseData(0, msg);
    }

    public static ResponseData error(String msg) {
        return new ResponseData(1, msg);
    }

    public static ResponseData okData(String key, Object value) {
        ResponseData data = new ResponseData(0, "Ok");
        data.putDataMap(key, value);
        return data;
    }

    public static ResponseData okData(List value, long count) {
        ResponseData data = new ResponseData(0, "Ok", count);
        if (value != null) {
            data.putData(value);
        }

        return data;
    }

    public static ResponseData okData(List value) {
        ResponseData data = new ResponseData(0, "Ok");
        if (value != null) {
            data.putData(value);
        }

        return data;
    }

    public static ResponseData okMap(Map<String, Object> map) {
        ResponseData data = new ResponseData(0, "Ok");
        return data.changeMap(map);
    }

    public static ResponseData notFound() {
        return new ResponseData(404, "暂无相关数据");
    }

    public static ResponseData badRequest() {
        return new ResponseData(400, "参数有误");
    }

    public static ResponseData forbidden() {
        return new ResponseData(403, "Forbidden");
    }

    public static ResponseData unauthorized() {
        return new ResponseData(401, "unauthorized");
    }

    public static ResponseData serviceException(int code, String msg) {
        return new ResponseData(code, msg);
    }

}