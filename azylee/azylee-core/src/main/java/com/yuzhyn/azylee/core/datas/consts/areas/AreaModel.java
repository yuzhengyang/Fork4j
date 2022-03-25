package com.yuzhyn.azylee.core.datas.consts.areas;

public class AreaModel {
    /**
     * id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 父id
     */
    private Integer parentId;
    /**
     * 简称
     */
    private String shortName;
    /**
     * 层级
     */
    private Integer levelType;
    /**
     * 城市编码
     */
    private String cityCode;
    /**
     * 邮政编码
     */
    private String zipCode;
    /**
     * 经度
     */
    private Double lng;
    /**
     * 纬度
     */
    private Double lat;
    /**
     * 拼音
     */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getLevelType() {
        return levelType;
    }

    public void setLevelType(Integer levelType) {
        this.levelType = levelType;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
}
