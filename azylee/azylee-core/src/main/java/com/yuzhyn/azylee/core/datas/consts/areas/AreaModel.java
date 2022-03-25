package com.yuzhyn.azylee.core.datas.consts.areas;

public class AreaModel {
    private Integer id;
    private String name;
    private Integer parentId;
    private String shortName;
    private Integer levelType;
    private String cityCode;
    private String zipCode;
    private Double lng;
    private Double lat;
    private String pinyin;

    public AreaModel(Integer id, String name, Integer parentId, String shortName, Integer levelType, String cityCode, String zipCode, Double lng, Double lat, String pinyin) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.shortName = shortName;
        this.levelType = levelType;
        this.cityCode = cityCode;
        this.zipCode = zipCode;
        this.lng = lng;
        this.lat = lat;
        this.pinyin = pinyin;
    }
}
