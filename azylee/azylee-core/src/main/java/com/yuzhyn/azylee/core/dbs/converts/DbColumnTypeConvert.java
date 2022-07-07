package com.yuzhyn.azylee.core.dbs.converts;


import com.yuzhyn.azylee.core.dbs.bases.DbTypeConst;

/**
 * 数据库列类型转换器
 */
public class DbColumnTypeConvert {

    /**
     * 数据库字段类型 转 java类型
     *
     * @param dbType 参数
     * @param columnType 参数
     * @return 返回 返回
     */
    public static String toJavaType(DbTypeConst dbType, String columnType) {
        String result = "";
        switch (dbType) {
            case SQLITE:

                break;
            default:
                break;
        }
        return result;
    }

    /**
     * java类型 转 数据库字段类型
     *
     * @param dbType 参数
     * @param javaType 参数
     * @return 返回 返回
     */
    public static String toColumnType(DbTypeConst dbType, String javaType) {
        switch (dbType) {
            case SQLITE: {

                switch (javaType) {
                    case "java.lang.String":
                        return "varchar";
                    case "java.lang.Integer":
                        return "int";
                    case "java.lang.Long":
                        return "bigint";
                    case "java.lang.Boolean":
                        return "boolean";
                    case "java.time.LocalDateTime":
                        return "datetime";
                }
                break;
            }

            default:
                break;
        }
        return "";
    }
}
