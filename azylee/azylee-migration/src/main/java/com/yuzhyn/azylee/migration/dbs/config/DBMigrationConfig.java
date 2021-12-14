package com.yuzhyn.azylee.migration.dbs.config;

import pers.yuzhyn.azylee.core.dbs.bases.DbType;

public class DBMigrationConfig {
    private DbType type;
    private String url;
    private String driverClass;
    private String user;
    private String password;
    private String table;

    DBMigrationConfig(DbType type, String url, String driverClass, String user, String password, String table) {
        this.type = type;
        this.url = url;
        this.driverClass = driverClass;
        this.user = user;
        this.password = password;
        this.table = table;
    }

    public DbType getType() {
        return type;
    }

    public void setType(DbType type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
