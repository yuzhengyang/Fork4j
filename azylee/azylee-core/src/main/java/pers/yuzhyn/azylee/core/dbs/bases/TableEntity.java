package pers.yuzhyn.azylee.core.dbs.bases;

import java.util.List;

/**
 * 数据表实体对象
 */
public class TableEntity {
    /**
     * 表名
     */
    private String name;
    /**
     * 主键列
     */
    private List<String> primaryKeys;
    /**
     * 索引列
     */
    private List<String> indexKeys;
    /**
     * 全部列
     */
    private List<String> columns;

}
