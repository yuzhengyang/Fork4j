package com.yuzhyn.azylee.core.datas.datetimes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public enum DateTimeFormatPattern {
    /**
     * 月
     */
    SHORT_MONTH("MM"),
    /**
     * 短年月
     */
    SHORT_YEAR_MONTH("yyyyMM"),
    /**
     * 短日期：20201124
     */
    SHORT_DATE("yyyyMMdd"),
    /**
     * 标准日期年月
     */
    NORMAL_YEAR_MONTH("yyyy-MM"),
    /**
     * 标准日期：2020-11-24
     */
    NORMAL_DATE("yyyy-MM-dd"),
    /**
     * 短日期时间：20201124144000
     */
    SHORT_DATETIME("yyyyMMddHHmmss"),
    /**
     * 标准日期时间：2020-11-24 14:40:00
     */
    NORMAL_DATETIME("yyyy-MM-dd HH:mm:ss"),
    /**
     * 标准日期时间SP：2020-1-4 1:4:0
     */
    NORMAL_DATETIME_SP("yyyy-M-d H:m:s"),
    /**
     * 标准日期时间-带毫秒：2020-11-24 14:40:00.659
     */
    NORMAL_DATETIME_MS("yyyy-MM-dd HH:mm:ss.SSS"),
    /**
     * 标准时间-带毫秒：14:40:00.659
     */
    NORMAL_TIME_MS("HH:mm:ss.SSS"),
    /**
     * 标准日期时间-带时区：2020-11-24T14:40:00+0800
     */
    NORMAL_DATETIME_TIMEZONE("yyyy-MM-dd'T'HH:mm:ss" + getTimeZone());


    public static String[] getDateTimePattern() {
        return new String[]{NORMAL_DATETIME.getPattern(), NORMAL_DATETIME_SP.getPattern(), SHORT_DATETIME.getPattern()};
    }


    private static String timeZone;

    public static String getTimeZone() {
        if (timeZone == null) {
            SimpleDateFormat sdf = new SimpleDateFormat("Z");
            sdf.setTimeZone(TimeZone.getDefault());
            timeZone = sdf.format(new Date());
        }
        return timeZone;
    }

    //region 属性、构造函数、Getter And Setter
    String pattern;

    DateTimeFormatPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    //endregion
}
