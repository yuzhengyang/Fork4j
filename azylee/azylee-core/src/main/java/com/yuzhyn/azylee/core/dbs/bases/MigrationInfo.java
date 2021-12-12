package com.yuzhyn.azylee.core.dbs.bases;

import com.yuzhyn.azylee.core.datas.collections.ListTool;

import java.util.ArrayList;
import java.util.List;

public class MigrationInfo {

    private List<MigrationItem> migrationItems;

    public void addMigrationItem(MigrationItem item) {
        if (migrationItems == null) migrationItems = new ArrayList<>();

        migrationItems.add(item);
    }


    public List<MigrationItem> getMigrationItems() {
        return migrationItems;
    }
}
