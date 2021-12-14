package com.yuzhyn.azylee.migration.dbs.adapters;

import com.yuzhyn.azylee.migration.dbs.DBMigration;
import com.yuzhyn.azylee.migration.dbs.config.DBMigrationConfig;
import com.yuzhyn.azylee.migration.dbs.entity.MigrationRecord;
import pers.yuzhyn.azylee.core.dbs.bases.DbType;

import java.util.List;
import java.util.Map;

public interface IMigrationAdapter {

    /**
     * 初始化适配器
     * @param config
     */
    void initAdapter(DBMigrationConfig config);

    /**
     * 获取需要执行的SQL语句
     *
     * @param id
     * @param type
     * @return
     */
    List<MigrationRecord> getNewSqlData(long id, DbType type);

    /**
     * 执行Sql语句
     * @param sqlList
     */
    void executeSql(List<MigrationRecord> sqlList);
}
