package pers.yuzhyn.azylee.core.datas.datetimes;

import pers.yuzhyn.azylee.core.logs.Alog;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTimeTool {


    public static LocalDateTime parse(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    public static LocalDateTime parse(String s) {
        LocalDateTime date = null;
        for (String pattern : DateTimeFormatPattern.getDateTimePattern()) {
            date = LocalDateTimeTool.parse(s, pattern);
            if (date == null && s.length() < 12) date = LocalDateTimeTool.parse(s + " 00:00:00", pattern);
            if (date != null) break;
        }
        return date;
    }

    public static LocalDateTime parse(String s, String format) {
        LocalDateTime dateTime = null;
        try {
            dateTime = LocalDateTime.parse(s, DateTimeFormatter.ofPattern(format));
        } catch (Exception ex) {
            Alog.e(ex.getMessage());
        }
        return dateTime;
    }

    public static void main(String[] args) {
        Alog.i(parse("2020-05-01 15:1:30").toString());
        Alog.i(parse("2020-05-01").toString());
    }
}
