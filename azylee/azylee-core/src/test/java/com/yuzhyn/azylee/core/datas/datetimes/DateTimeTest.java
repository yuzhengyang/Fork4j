package com.yuzhyn.azylee.core.datas.datetimes;

import java.time.LocalDateTime;

public class DateTimeTest {
    public static void main(String[] args) {
        System.out.println(DateTimeFormat.toStr(LocalDateTime.now(), DateTimeFormatPattern.NORMAL_DATETIME_TIMEZONE));
        System.out.println(DateTimeFormat.toStr(LocalDateTime.now(), DateTimeFormatPattern.NORMAL_DATETIME_TIMEZONE));
        System.out.println(DateTimeFormat.toStr(LocalDateTime.now(), DateTimeFormatPattern.NORMAL_DATETIME_TIMEZONE));
    }
}
