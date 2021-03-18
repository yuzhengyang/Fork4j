package pers.yuzhyn.azylee.core.datas.regexs;

import pers.yuzhyn.azylee.core.logs.Alog;

import java.util.regex.Pattern;

public enum RegexPattern {
    /**
     * 英文字母 、数字和下划线
     */
    GENERAL(Pattern.compile("^\\w+$"));

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
        Alog.v("zhangsanfeng00111 " + RegexPattern.GENERAL.isMatch("zhangsanfeng00111"));
        Alog.v("zhangsanfeng00111张 " + RegexPattern.GENERAL.isMatch("zhangsanfeng00111张"));
        Alog.v("zhangsanfeng00111张~ " + RegexPattern.GENERAL.isMatch("zhangsanfeng00111张~"));
        Alog.v("zhangsanfeng_00111 " + RegexPattern.GENERAL.isMatch("zhangsanfeng_00111"));
        Alog.v("zhangsanfeng_+00111 " + RegexPattern.GENERAL.isMatch("zhangsanfeng_+00111"));
    }
}
