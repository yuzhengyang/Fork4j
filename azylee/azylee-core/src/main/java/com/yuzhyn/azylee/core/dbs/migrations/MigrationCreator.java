package com.yuzhyn.azylee.core.dbs.migrations;

import com.yuzhyn.azylee.core.dbs.bases.MigrationInfo;
import com.yuzhyn.azylee.core.dbs.bases.MigrationItem;

/**
 * 数据库迁移信息创建工具
 * 用来创建记录每一次的数据库结构及信息改变脚本
 */
public class MigrationCreator {
    public MigrationInfo create(MigrationItem... items) {
        MigrationInfo migrationInfo = new MigrationInfo();
        for (MigrationItem item : items) {
            migrationInfo.addMigrationItem(item);
        }
        return migrationInfo;
    }
}
