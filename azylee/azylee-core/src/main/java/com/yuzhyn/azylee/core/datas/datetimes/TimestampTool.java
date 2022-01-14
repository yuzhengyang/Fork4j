package com.yuzhyn.azylee.core.datas.datetimes;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TimestampTool {

    public static LocalDateTime toLocalDateTime(Timestamp time) {
        LocalDateTime localDateTime = time.toLocalDateTime();
        return localDateTime;
    }

    public static long totalSecond() {
        return System.currentTimeMillis() / 1000;
    }

    public static long totalMinute() {
        return totalSecond() / 60;
    }

    public static long totalHour() {
        return totalMinute() / 60;
    }

//    public static void main(String[] args) {
//        System.out.println(TimestampTool.totalMinute());
//    }
}
