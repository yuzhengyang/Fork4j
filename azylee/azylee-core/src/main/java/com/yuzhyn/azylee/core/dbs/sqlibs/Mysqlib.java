package com.yuzhyn.azylee.core.dbs.sqlibs;

/**
 * 功能性SQL语句库
 */
public class Mysqlib {
    public static final String VALUE = "$$value$$";

    /**
     * 查看表空间占用磁盘情况
     */
    public static final String SCHEMA_SIZE = "SELECT t.* FROM (SELECT table_schema, TRUNCATE(SUM(data_length)/1024/1024,2) AS data_size,TRUNCATE(SUM(index_length)/1024/1024,2) AS index_size FROM information_schema.tables GROUP BY table_schema) t ORDER BY t.data_size DESC";

    /**
     * 当前运行的所有事务（带参数）
     * innodb_trx 当前运行的所有事务
     * innodb_locks 当前出现的锁
     * innodb_lock_waits 锁等待的对应关系
     */
    public static final String INNODB_TRX = "SELECT * FROM information_schema.innodb_trx WHERE trx_query LIKE '$$value$$'";

    /**
     * 查询线程信息（带参数）
     */
    public static final String PROCESS_LIST = "SELECT * FROM information_schema.processlist WHERE id = '$$value$$'";
}
