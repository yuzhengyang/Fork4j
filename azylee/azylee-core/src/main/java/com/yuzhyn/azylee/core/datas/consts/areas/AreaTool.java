package com.yuzhyn.azylee.core.datas.consts.areas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 区域
 */
public class AreaTool {
    /**
     * 常量
     */
    private List<AreaModel> areaModelList = new ArrayList<>();

    /**
     * 创建信息
     */
    public void create() {
//        areaModelList.addAll(AreaCreater.create());
    }

    /**
     * 获取省列表
     * @return 返回区域
     */
    public List<AreaModel> getProvince() {
        return areaModelList.stream().filter(x -> x.getLevelType() == 1).collect(Collectors.toList());
    }

    /**
     * 获取城市列表
     * @param name name
     * @return 返回城市
     */
    public List<AreaModel> getProvince(String name) {
        // 首先应该按照名称获取省信息，然后通过父id过滤出城市列表
        return areaModelList.stream().filter(x -> x.getLevelType() == 2).collect(Collectors.toList());
    }
}
