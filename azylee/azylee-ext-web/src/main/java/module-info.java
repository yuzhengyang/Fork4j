open module com.yuzhyn.azylee.ext.web {
    requires reactor.core;
    requires okhttp3;
    requires com.yuzhyn.azylee.core;
    requires com.alibaba.fastjson2;
    requires jsch;
    requires jakarta.mail;

    exports com.yuzhyn.azylee.ext.web.apis.baidu;
    exports com.yuzhyn.azylee.ext.web.apis.ipplus;
    exports com.yuzhyn.azylee.ext.web.apis.taobao;
    exports com.yuzhyn.azylee.ext.web.mails;


}