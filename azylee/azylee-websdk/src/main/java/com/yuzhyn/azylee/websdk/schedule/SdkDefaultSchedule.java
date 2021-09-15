package com.yuzhyn.azylee.websdk.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Component
@EnableScheduling
@EnableAsync
public class SdkDefaultSchedule {


    @Async
    @Scheduled(cron = "0 */1 * * * ?")
    public void job() {
        System.out.println("SDK 默认定时任务执行");
    }
}
