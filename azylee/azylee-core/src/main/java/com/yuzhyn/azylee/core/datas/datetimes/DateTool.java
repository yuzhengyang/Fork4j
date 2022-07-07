package com.yuzhyn.azylee.core.datas.datetimes;

import com.yuzhyn.azylee.core.datas.strings.StringTool;
import com.yuzhyn.azylee.core.logs.Alog;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateTool {

    public static Date parse(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date parse(String s) {
        Date date = null;
        for (String pattern : DateTimeFormatPattern.getDateTimePattern()) {
            date = DateTool.parse(s, pattern);
            if (date == null && s.length() < 12) date = DateTool.parse(s + " 00:00:00", pattern);
            if (date != null) break;
        }
        return date;
    }

    public static Date parse(String s, String format) {
        if (StringTool.ok(s)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            try {
                return sdf.parse(s);
            } catch (Exception ex) {
                Alog.e(ex.getMessage());
            }
        }
        return null;
    }

    public static Date parse(String s, DateTimeFormatPattern pattern) {
        if (StringTool.ok(s)) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern.getPattern());
            try {
                return sdf.parse(s);
            } catch (Exception ex) {
            }
        }
        return null;
    }

    public static Date parse(int year, int month, int day) {
        return DateTool.parse(year + "-" + month + "-" + day);
    }

    public static Date parse(int year, int month, int day, int hour, int minute, int second) {
        return DateTool.parse(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);
    }


    /**
     * 时间增加 second 秒
     *
     * @param date 参数
     * @param second 参数
     * @return 返回 返回
     */
    public static Date addSecond(Date date, int second) {
        Long time = date.getTime();
        time = time + (second * 1000);
        return new Date(time);
    }

    /**
     * 时间增加 second 秒（long类型）
     *
     * @param date 参数
     * @param second 参数
     * @return 返回 返回
     */
    public static Date addSecond(Date date, long second) {
        Long time = date.getTime();
        time = time + (second * 1000);
        return new Date(time);
    }

    /**
     * 时间增加 minute 分钟
     *
     * @param date 参数
     * @param minute 参数
     * @return 返回 返回
     */
    public static Date addMinute(Date date, int minute) {
        return DateTool.addSecond(date, minute * 60L);
    }

    /**
     * 时间增加 hour 小时
     *
     * @param date 参数
     * @param hour 参数
     * @return 返回 返回
     */
    public static Date addHour(Date date, int hour) {
        return DateTool.addMinute(date, hour * 60);
    }

    /**
     * 时间增加 day 天
     *
     * @param date 参数
     * @param day 参数
     * @return 返回 返回
     */
    public static Date addDay(Date date, int day) {
        return DateTool.addHour(date, day * 24);
    }

    /**
     * 时间增加 month 月
     *
     * @param date 参数
     * @param month 参数
     * @return 返回 返回
     */
    public static Date addMonth(Date date, int month) {
        LocalDateTime localDateTime = LocalDateTimeTool.parse(date);
        localDateTime = localDateTime.plusMonths(month);
        return DateTool.parse(localDateTime);
    }

    /**
     * 时间增加 year 年
     *
     * @param date 参数
     * @param year 参数
     * @return 返回 返回
     */
    public static Date addYear(Date date, int year) {
        LocalDateTime localDateTime = LocalDateTimeTool.parse(date);
        localDateTime = localDateTime.plusYears(year);
        return DateTool.parse(localDateTime);
    }

    public static void main(String[] args) {
        Alog.i(parse("2020-5-1 5:12:30").toString());
        Alog.i(parse("2020-5-1").toString());

        Alog.i("---------------------------------------------");
        Date date = new Date();
        Alog.i(DateTimeFormat.toStr(date));
        Alog.i(DateTimeFormat.toStr(DateTool.addSecond(date, 3600)));
        Alog.i(DateTimeFormat.toStr(DateTool.addMinute(date, 10)));
        Alog.i(DateTimeFormat.toStr(DateTool.addHour(date, 10)));
        Alog.i(DateTimeFormat.toStr(DateTool.addDay(date, 3)));
        Alog.i(DateTimeFormat.toStr(DateTool.addMonth(date, 3)));
        Alog.i(DateTimeFormat.toStr(DateTool.addYear(date, 3)));
    }
}
