package com.yuzhyn.azylee.core.datas.consts.areas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AreaTool {
    private List<AreaModel> areaModelList = new ArrayList<>();

    public void create() {
//        areaModelList.addAll(AreaCreater.create());
    }

    /**
     * 获取省列表
     * @return
     */
    public List<AreaModel> getProvince() {
        return areaModelList.stream().filter(x -> x.getLevelType() == 1).collect(Collectors.toList());
    }
    /**
     * 获取城市列表
     * @return
     */
    public List<AreaModel> getProvince(String name) {
        // 首先应该按照名称获取省信息，然后通过父id过滤出城市列表
        return areaModelList.stream().filter(x -> x.getLevelType() == 2).collect(Collectors.toList());
    }
}
