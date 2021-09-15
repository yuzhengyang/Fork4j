package com.yuzhyn.azylee.websdk.model.users;

import java.time.LocalDateTime;

public class UserFileConf {

    private String userId;
    private LocalDateTime createTime;
    private LocalDateTime expiryTime;
    private Long spaceLimit;
    private Long usedSpace;
    private String urlPrefix;

    //region Description

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public Long getSpaceLimit() {
        return spaceLimit;
    }

    public void setSpaceLimit(Long spaceLimit) {
        this.spaceLimit = spaceLimit;
    }

    public Long getUsedSpace() {
        return usedSpace;
    }

    public void setUsedSpace(Long usedSpace) {
        this.usedSpace = usedSpace;
    }

    public String getUrlPrefix() {
        return urlPrefix;
    }

    public void setUrlPrefix(String urlPrefix) {
        this.urlPrefix = urlPrefix;
    }

    //endregion
}
