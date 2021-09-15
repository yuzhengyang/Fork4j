package com.yuzhyn.azylee.core.datas.datetimes;

import java.util.Calendar;

public enum MonthEnum {
    /**
     * 一月
     */
    JANUARY("JANUARY", "一月", 1, Calendar.JANUARY, 31),
    /**
     * 二月
     */
    FEBRUARY("FEBRUARY", "二月", 2, Calendar.FEBRUARY, 28),
    /**
     * 三月
     */
    MARCH("MARCH", "三月", 3, Calendar.MARCH, 31),
    /**
     * 四月
     */
    APRIL("APRIL", "四月", 4, Calendar.APRIL, 30),
    /**
     * 五月
     */
    MAY("MAY", "五月", 5, Calendar.MAY, 31),
    /**
     * 六月
     */
    JUNE("JUNE", "六月", 6, Calendar.JUNE, 30),
    /**
     * 七月
     */
    JULY("JULY", "七月", 7, Calendar.JULY, 31),
    /**
     * 八月
     */
    AUGUST("AUGUST", "八月", 8, Calendar.AUGUST, 31),
    /**
     * 九月
     */
    SEPTEMBER("SEPTEMBER", "九月", 9, Calendar.SEPTEMBER, 30),
    /**
     * 十月
     */
    OCTOBER("OCTOBER", "十月", 10, Calendar.OCTOBER, 31),
    /**
     * 十一月
     */
    NOVEMBER("NOVEMBER", "十一月", 11, Calendar.NOVEMBER, 30),
    /**
     * 十二月
     */
    DECEMBER("DECEMBER", "十二月", 12, Calendar.DECEMBER, 31),
    /**
     * 十三月，农历
     */
    UNDECIMBER("UNDECIMBER", "十三月", 13, Calendar.UNDECIMBER, 0);


    //region 构造函数、属性及get、set方法
    MonthEnum(String name, String nameCn, int number, int calendarValue, int days) {
        this.name = name;
        this.nameCn = nameCn;
        this.number = number;
        this.calendarValue = calendarValue;
        this.days = days;
    }

    private String name;
    private String nameCn;
    private int number;
    private int calendarValue;
    private int days;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCalendarValue() {
        return calendarValue;
    }

    public void setCalendarValue(int calendarValue) {
        this.calendarValue = calendarValue;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
    //endregion
}
