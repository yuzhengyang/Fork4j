package com.yuzhyn.azylee.core.dbs.generates;

import com.yuzhyn.azylee.core.datas.datetimes.DateTimeFormat;
import com.yuzhyn.azylee.core.datas.datetimes.DateTimeFormatPattern;
import com.yuzhyn.azylee.core.datas.strings.StringTool;

import java.time.LocalDateTime;

public class SqlCustomReplaceKey {
    public static String replaceKey(String s) {
        LocalDateTime now = LocalDateTime.now();
        s = StringTool.replace(s, "${{time.now.MM}}", DateTimeFormat.toStr(now, DateTimeFormatPattern.SHORT_MONTH));
        s = StringTool.replace(s, "${{time.now.yyyyMM}}", DateTimeFormat.toStr(now, DateTimeFormatPattern.SHORT_YEAR_MONTH));
        s = StringTool.replace(s, "${{time.lstmon-1st.yyyy-MM-dd}}", DateTimeFormat.toStr(now.plusMonths(-1), DateTimeFormatPattern.NORMAL_YEAR_MONTH) + "-01");
        return s;
    }
}
