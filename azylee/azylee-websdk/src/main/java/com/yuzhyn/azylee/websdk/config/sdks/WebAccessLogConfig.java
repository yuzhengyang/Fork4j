package com.yuzhyn.azylee.websdk.config.sdks;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WebAccessLogConfig {
    public static boolean enable;
    public static boolean printlog;

    @Value("${azylee.websdk.webAccessLog.enable:false}")
    public void setEnable(boolean enable) {
        WebAccessLogConfig.enable = enable;
    }

    @Value("${azylee.websdk.webAccessLog.printlog:false}")
    public void setPrintlog(boolean printlog) {
        WebAccessLogConfig.printlog = printlog;
    }

    public static void output() {
        System.out.println("enable: " + WebAccessLogConfig.enable +
                ", printlog: " + WebAccessLogConfig.printlog);
    }
}
