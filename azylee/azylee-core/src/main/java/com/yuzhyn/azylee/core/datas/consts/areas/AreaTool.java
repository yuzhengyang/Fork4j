package com.yuzhyn.azylee.core.datas.consts.areas;

import java.util.ArrayList;
import java.util.List;

public class AreaTool {
    private List<AreaModel> areaModelList = new ArrayList<>();

    public void create() {
        areaModelList.addAll(AreaCreater.create());
        // 序列化为树结构

    }
}
