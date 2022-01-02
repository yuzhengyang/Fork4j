package com.yuzhyn.azylee.websdk.config.sdks;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 访问日志记录配置
 * 开启后，需要手动监控内存队列信息
 */
@Component
public class WebAccessLogConfig {
    public static boolean enable;
    public static boolean printlog;

    /**
     * 是否启用访问日志记录
     * @param enable 参数
     */
    @Value("${azylee.websdk.webAccessLog.enable:false}")
    public void setEnable(boolean enable) {
        WebAccessLogConfig.enable = enable;
    }

    /**
     * 是否启用访问日志记录输出日志
     * @param printlog 参数
     */
    @Value("${azylee.websdk.webAccessLog.printlog:false}")
    public void setPrintlog(boolean printlog) {
        WebAccessLogConfig.printlog = printlog;
    }

    public static void output() {
        System.out.println("enable: " + WebAccessLogConfig.enable +
                ", printlog: " + WebAccessLogConfig.printlog);
    }
}
