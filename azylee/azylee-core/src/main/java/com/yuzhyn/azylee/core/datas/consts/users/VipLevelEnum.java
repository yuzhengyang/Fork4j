package com.yuzhyn.azylee.core.datas.consts.users;

public enum VipLevelEnum {
    N1("普通用户-1", 1),
    N2("普通用户-2", 2),
    N3("普通用户-3", 3),

    T1("临时会员-1", 11),
    T2("临时会员-2", 12),
    T3("临时会员-3", 13),

    V1("普通会员-1", 101),
    V2("普通会员-2", 102),
    V3("普通会员-3", 103),

    S1("高级会员-1", 1001),
    S2("高级会员-2", 1002),
    S3("高级会员-3", 1003);


    //region 构造函数、属性及get、set方法
    VipLevelEnum(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        return String.valueOf(level);
    }

    private String name;
    private int level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    //endregion
}