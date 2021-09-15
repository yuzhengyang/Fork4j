package com.yuzhyn.azylee.core.dbs.sqls;

public class SqlDefender {
    public static String replace(String sql) {
        sql = sql.replace('\'', '\'');
        return sql;
    }
}