package com.yuzhyn.azylee.migration.dbs.adapters;

import com.yuzhyn.azylee.migration.dbs.config.DBMigrationConfig;
import com.yuzhyn.azylee.migration.dbs.entity.MigrationRecord;
import pers.yuzhyn.azylee.core.dbs.bases.DbType;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySqlMigrationAdapter implements IMigrationAdapter {

    DBMigrationConfig config = null;

    @Override
    public void initAdapter(DBMigrationConfig _config) {
        config = _config;
    }

    @Override
    public List<MigrationRecord> getNewSqlData(long id, DbType type) {
        List<MigrationRecord> resultList = new ArrayList<>();
        try {
            //1.加载驱动程序
            Class.forName(config.getDriverClass());
            //2. 获得数据库连接
            Connection conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
            //3.操作数据库，实现增删改查
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + config.getTable());
            //如果有数据，rs.next()返回true
            while (rs.next()) {
                MigrationRecord record = new MigrationRecord();
                record.setId(rs.getLong(""));
                record.setDbType(rs.getString(""));
                record.setSql(rs.getString(""));
                record.setAuthor(rs.getString(""));
                record.setCreateTime(rs.getDate(""));
                record.setUpdateTime(rs.getDate(""));
                record.setExecuteTime(rs.getDate(""));
                record.setExecuteStatus(rs.getInt(""));
                record.setExecuteResult(rs.getString(""));
                resultList.add(record);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public void executeSql(List<MigrationRecord> sqlList) {
        try {
            //1.加载驱动程序
            Class.forName(config.getDriverClass());
            //2. 获得数据库连接
            Connection conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
            //3.操作数据库，实现增删改查
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT user_name, age FROM imooc_goddess");
            //如果有数据，rs.next()返回true
            while (rs.next()) {
                System.out.println(rs.getString("user_name") + " 年龄：" + rs.getInt("age"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
