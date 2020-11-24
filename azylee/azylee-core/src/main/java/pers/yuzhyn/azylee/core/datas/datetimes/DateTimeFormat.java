package pers.yuzhyn.azylee.core.datas.datetimes;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期时间格式化工具
 *
 * @author yuzhengyang
 * @version 1.0
 *
 * #date 2020年11月24日
 */
public class DateTimeFormat {

    /**
     * 按照指定格式格式化日期时间
     *
     * @param date 日期
     * @param pattern 格式
     * @return 返回
     */
    public static String toStr(Date date, DateTimeFormatPattern pattern) {
        if (date != null) {
            try {
                return new SimpleDateFormat(pattern.getPattern()).format(date);
            } catch (Exception ex) {
            }
        }
        return null;
    }

    /**
     * 按照默认格式格式化日期时间
     *
     * @param date 日期
     * @return 返回
     */
    public static String toStr(Date date) {
        return toStr(date, DateTimeFormatPattern.NORMAL_DATETIME);
    }

    /**
     * 按照指定格式格式化日期时间
     *
     * @param dateTime 日期时间
     * @param pattern 格式
     * @return 返回
     */
    public static String toStr(LocalDateTime dateTime, DateTimeFormatPattern pattern) {
        if (dateTime != null) {
            try {
                DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern.getPattern());
                String s = df.format(dateTime);
                return s;
            } catch (Exception ex) {
            }
        }
        return null;
    }

    /**
     * 按照默认格式格式化日期时间
     *
     * @param dateTime 日期时间
     * @return 返回
     */
    public static String toStr(LocalDateTime dateTime) {
        return toStr(dateTime, DateTimeFormatPattern.NORMAL_DATETIME);
    }

    public static void main(String[] args) {
        System.out.println(DateTimeFormat.toStr(new Date(), DateTimeFormatPattern.NORMAL_DATETIME));
        System.out.println(DateTimeFormat.toStr(LocalDateTime.now(), DateTimeFormatPattern.NORMAL_DATETIME));
    }
}
