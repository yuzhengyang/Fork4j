package pers.yuzhyn.azylee.core.datas.datetimes;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TimestampTool {

    public static LocalDateTime toLocalDateTime(Timestamp time) {
        LocalDateTime localDateTime = time.toLocalDateTime();
        return localDateTime;
    }
}
