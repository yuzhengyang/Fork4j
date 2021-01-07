package pers.yuzhyn.azylee.core.datas.datetimes;

import pers.yuzhyn.azylee.core.datas.strings.StringTool;
import pers.yuzhyn.azylee.core.logs.Log;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateTool {

    public static Date parse(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date parse(String dateString) {
        Date date = DateTool.parse(dateString, DateTimeFormatPattern.NORMAL_DATETIME.getPattern());
        if (date == null) {
            date = DateTool.parse(dateString, DateTimeFormatPattern.NORMAL_DATE.getPattern());
        }
        return date;
    }

    public static Date parse(String dateString, String format) {
        if (StringTool.ok(dateString)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            try {
                return sdf.parse(dateString);
            } catch (Exception ex) {
                Log.e(ex.getMessage());
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
}
