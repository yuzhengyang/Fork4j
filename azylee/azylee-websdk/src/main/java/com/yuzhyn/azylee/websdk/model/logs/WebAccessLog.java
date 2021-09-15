package com.yuzhyn.azylee.websdk.model.logs;

import java.time.LocalDateTime;

public class WebAccessLog {
    private String id;
    private String ip;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private String uri;
    private String method;
    private Long elapsedTime;
    private String userId;
    private String step;
    private String threadName;
    private Long beginMaxMemory;
    private Long beginTotalMemory;
    private Long beginFreeMemory;
    private Long endMaxMemory;
    private Long endTotalMemory;
    private Long endFreeMemory;
    private Long probablyUseMemory;
    private String exception;

    //region get and set
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public Long getBeginMaxMemory() {
        return beginMaxMemory;
    }

    public void setBeginMaxMemory(Long beginMaxMemory) {
        this.beginMaxMemory = beginMaxMemory;
    }

    public Long getBeginTotalMemory() {
        return beginTotalMemory;
    }

    public void setBeginTotalMemory(Long beginTotalMemory) {
        this.beginTotalMemory = beginTotalMemory;
    }

    public Long getBeginFreeMemory() {
        return beginFreeMemory;
    }

    public void setBeginFreeMemory(Long beginFreeMemory) {
        this.beginFreeMemory = beginFreeMemory;
    }

    public Long getEndMaxMemory() {
        return endMaxMemory;
    }

    public void setEndMaxMemory(Long endMaxMemory) {
        this.endMaxMemory = endMaxMemory;
    }

    public Long getEndTotalMemory() {
        return endTotalMemory;
    }

    public void setEndTotalMemory(Long endTotalMemory) {
        this.endTotalMemory = endTotalMemory;
    }

    public Long getEndFreeMemory() {
        return endFreeMemory;
    }

    public void setEndFreeMemory(Long endFreeMemory) {
        this.endFreeMemory = endFreeMemory;
    }

    public Long getProbablyUseMemory() {
        return probablyUseMemory;
    }

    public void setProbablyUseMemory(Long probablyUseMemory) {
        this.probablyUseMemory = probablyUseMemory;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
    //endregion
}
