package com.yuzhyn.azylee.core.datas.consts.users;

public enum UserRoleEnum {
    USER("用户", 1),
    ADMIN("管理员", 11),
    SA("超级管理员", 1000);


    //region 构造函数、属性及get、set方法
    UserRoleEnum(String name, int code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return String.valueOf(code);
    }

    private String name;
    private int code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    //endregion
}