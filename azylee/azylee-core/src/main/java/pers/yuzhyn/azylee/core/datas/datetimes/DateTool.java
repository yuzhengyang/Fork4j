package pers.yuzhyn.azylee.core.datas.datetimes;

import pers.yuzhyn.azylee.core.datas.strings.StringTool;
import pers.yuzhyn.azylee.core.logs.Alog;

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

    public static Date parse(int year, int month, int day) {
        return DateTool.parse(year + "-" + month + "-" + day);
    }

    public static Date parse(int year, int month, int day, int hour, int minute, int second) {
        return DateTool.parse(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);
    }

    public static void main(String[] args) {
        Alog.i(parse("2020-5-1 5:12:30").toString());
        Alog.i(parse("2020-5-1").toString());
    }
}
