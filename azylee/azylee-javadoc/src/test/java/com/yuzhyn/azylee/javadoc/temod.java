package com.yuzhyn.azylee.javadoc;

/**
 * <div javadoc="info" javadoc-cn="一句话精简概括">
 *     数据库基本方法
 * </div>
 *
 * <div javadoc="scene" javadoc-cn="使用场景说明">
 *     数据查询时，使用平台需要写大量SQL语句执行，但是对于普通增删改查，可使用基本方法工具，省去了手写SQL
 * </div>
 *
 * <div javadoc="limit" javadoc-cn="使用限制说明">
 *     工具提供动态修改表名的方法，并发时会影响Spring注入的全局对象
 * </div>
 *
 * <div javadoc="code" javadoc-cn="使用代码示例">
 *     Dao类创建示例
 *     ```java
 *     @Component
 *     @HiDbTable(tableName = "sys_org",
 *             tableColumns = "org_id,org_code,p_org_code,org_name,org_help_name,org_modal,org_abbr_name,status,org_level,is_self_org,crt_time,crt_user_id,upd_time",
 *             primaryKeys = "org_id")
 *     public class SysOrgDao extends HiDbModel<SysOrgDao> {
 *         // 其中可包括其他扩展查询方法
 *     }
 *     ```
 * <p>
 *     Service类中使用声明
 *     ```java
 *     @Autowired
 *     SysOrgDao sysOrgDao;
 *     ```
 * </div>
 *
 * <div javadoc="log" javadoc-cn="修改日志">
 * 版本         修改时间       修改人         修改内容
 * 7.0.0.1     2021-02-24    fanxueping     CMPS-1891配货池增加selectByIdFUdp
 * </div>
 */
public class temod {
    //region Dao自带属性设置获取

    /**
     * <div javadoc="info" javadoc-cn="一句话精简概括">
     *     获取实际操作类（不建议使用）
     * </div>
     *
     * <div javadoc="limit" javadoc-cn="使用限制说明">
     *     不建议使用底层操作类，可能导致不稳定情况发生
     * </div>
     *
     * @return
     */
    @Deprecated
    public String getDbAssist() {
        return "";
    }

    /**
     * <div javadoc="info" javadoc-cn="一句话精简概括">
     *     设置新的表名
     * </div>
     *
     * @param tableName 表名
     */
    public void setTableName(String tableName) {
    }

    /**
     * <div javadoc="info" javadoc-cn="一句话精简概括">
     *     获取当前设置的表名
     * </div>
     *
     * @return
     */
    public String getTableName() {
        return "";
    }

    /**
     * <div javadoc="info" javadoc-cn="一句话精简概括">
     *     查询数据列表
     * </div>
     *
     * <div javadoc="code" javadoc-cn="使用代码示例">
     *     声明
     *     ```java
     *     @Autowired
     *     SysOrgDao sysOrgDao;
     *     ```
     *     使用
     *     ```java
     *     DataRow param = new DataRow();
     *     param.set("billNo","BILL202111151411");
     *     DataTable table = sysOrgDao.select(portalAdapter, param, "status = 1 AND bill_no = :billNo");
     *     ```
     * </div>
     *
     * @param iDataAdapter 数据库连接
     * @param data         查询语句参数
     * @param where        查询条件语句
     * @return
     */
    public void select(String iDataAdapter, String data, String where) {

    }

}