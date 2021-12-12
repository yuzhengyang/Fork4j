package com.yuzhyn.azylee.core.dbs.bases;

public class MigrationItem {
    private Long id;
    private String sql;

    public MigrationItem(Long id, String sql) {
        this.id = id;
        this.sql = sql;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
