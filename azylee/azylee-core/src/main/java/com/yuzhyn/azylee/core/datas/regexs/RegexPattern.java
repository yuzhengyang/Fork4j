package com.yuzhyn.azylee.core.datas.regexs;

import com.yuzhyn.azylee.core.logs.Alog;

import java.util.regex.Pattern;

public enum RegexPattern {
    /**
     * 英文字母 、数字和下划线
     */
    GENERAL(Pattern.compile("^\\w+$")),
    /**
     * 正整数
     */
    POSITIVE_INTEGER(Pattern.compile("^[1-9]\\d*$")),
    /**
     * 正浮点数
     */
    POSITIVE_FLOAT(Pattern.compile("^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$")),
    /**
     * 校验正整数和0（非负整数）
     */
    POSITIVE_INTEGER_AND_ZERO(Pattern.compile("^[0-9]*[0-9][0-9]*$")),
    /**
     * 校验正整数（含.0的小数）和0
     */
    REAL_POSITIVE_INTEGER_AND_ZERO(Pattern.compile("^[0-9]*[0-9][0-9]*(\\.?0+)*$")),
    /**
     * 数字（ 大于等于 0的数）
     */
    POSITIVE_NUMBER_AND_ZERO(Pattern.compile("^[0-9]+([.]{1}[0-9]+){0,1}$")),
    /**
     * 校验数字
     */
    NUMBER(Pattern.compile("^-?[0-9]+([.]{1}[0-9]+){0,1}$")),
    /**
     * 大于0的数字
     */
    NONNEGATIVE_DECIMAL(Pattern.compile("^([1-9]\\d*(\\.\\d{0,4})?)|(0\\.\\d{0,4})$")),
    /**
     * 大于等于0的数字
     */
    NONNEGATIVE_DECIMAL_ZERO(Pattern.compile("^([1-9]\\d*(\\.\\d{0,4})?)|(0(\\.\\d{0,4})?)$"));

    //region 属性、构造函数、Getter And Setter
    Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean isMatch(CharSequence content) {
        if (content != null && pattern != null) {
            return pattern.matcher(content).matches();
        }
        return false;
    }
    //endregion

    public static void main(String[] args) {
        Alog.v(RegexPattern.GENERAL.getPattern().pattern());

        Alog.v("zhangsanfeng00111 " + RegexPattern.GENERAL.isMatch("zhangsanfeng00111"));
        Alog.v("zhangsanfeng00111张 " + RegexPattern.GENERAL.isMatch("zhangsanfeng00111张"));
        Alog.v("zhangsanfeng00111张~ " + RegexPattern.GENERAL.isMatch("zhangsanfeng00111张~"));
        Alog.v("zhangsanfeng_00111 " + RegexPattern.GENERAL.isMatch("zhangsanfeng_00111"));
        Alog.v("zhangsanfeng_+00111 " + RegexPattern.GENERAL.isMatch("zhangsanfeng_+00111"));
    }
}
