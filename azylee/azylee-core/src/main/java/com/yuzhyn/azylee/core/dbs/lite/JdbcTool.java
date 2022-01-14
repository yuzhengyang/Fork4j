package com.yuzhyn.azylee.core.dbs.lite;

import com.yuzhyn.azylee.core.datas.strings.StringTool;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTool {

    private String type;
    private String url;

    private String host;
    private int port;
    private String urlParams;

    private String driverClass;
    private String username;
    private String password;

    private String schema;

    public JdbcTool(String _type, String _url, String _driverClass, String _username, String _password) {
        this.type = _type;
        this.url = _url;
        this.driverClass = _driverClass;
        this.username = _username;
        this.password = _password;
    }

    public JdbcTool(String _type, String _host, int _port, String _schema, String _urlParams, String _driverClass, String _username, String _password) {
        this.type = _type;
        this.host = _host;
        this.port = _port;
        this.schema = _schema;
        this.urlParams = _urlParams;
        this.driverClass = _driverClass;
        this.username = _username;
        this.password = _password;
        this.generateUrl();
    }

    private void generateUrl() {
        String _url;
        // 生成主要url
        switch (type) {
            case "postgresql":
            case "mysql":
            default: {
                _url = "jdbc:" + this.type + "://" + this.host + ":" + this.port + "/" + this.schema;
                break;
            }
        }
        // 拼接url参数
        if (StringTool.ok(this.urlParams)) {
            _url = _url + "?" + this.urlParams;
        }
        this.url = _url;
    }

    public List<Map> query(String sql) throws ClassNotFoundException, SQLException {
        List<Map> resultList = new ArrayList<>();

        //1.加载驱动程序
        Class.forName(this.driverClass);
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ResultSetMetaData rsMetaData = rs.getMetaData();
        int count = rsMetaData.getColumnCount();
        //如果有数据，rs.next()返回true
        while (rs.next()) {
            Map record = new HashMap();
            for (int i = 1; i <= count; i++) {
                String _columnName = rsMetaData.getColumnName(i);
                record.put(_columnName, rs.getObject(_columnName));
            }
            resultList.add(record);
        }

        return resultList;
    }

    public Object queryCell(String sql, int index, String columnName) throws SQLException, ClassNotFoundException {
        List<Map> rows = this.query(sql);
        if (rows.size() > index) {
            return rows.get(index).get(columnName);
        }
        return null;
    }

    public Object queryFirstCell(String sql, String columnName) throws SQLException, ClassNotFoundException {
        return this.queryCell(sql, 0, columnName);
    }

    public Object queryFirstCell(String sql) throws SQLException, ClassNotFoundException {
        List<Map> rows = this.query(sql);
        if (rows.size() > 0) {
            for (Object object : rows.get(0).values()) {
                return object;
            }
        }
        return null;
    }
}
