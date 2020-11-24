package pers.yuzhyn.azylee.core.datas.datetimes;

public enum DateTimeFormatPattern {
    /**
     * 短日期：20201124
     */
    SHORT_DATE("yyyyMMdd"),
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
    NORMAL_DATETIME("yyyy-MM-dd HH:mm:ss");

    String pattern;

    DateTimeFormatPattern(String pattern) {
        this.pattern = pattern;
    }

    //region Getter And Setter
    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    //endregion
}
