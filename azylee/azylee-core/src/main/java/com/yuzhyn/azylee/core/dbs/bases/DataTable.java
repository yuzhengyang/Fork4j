package com.yuzhyn.azylee.core.dbs.bases;

import java.util.List;

public class DataTable {

    public DataTable(List<DataRow> dataRows) {
        this.dataRows = dataRows;
    }

    List<DataRow> dataRows;

    public List<DataRow> getDataRows() {
        return dataRows;
    }

    public void setDataRows(List<DataRow> dataRows) {
        this.dataRows = dataRows;
    }
}
