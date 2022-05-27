package com.yuzhyn.azylee.core.systems.models;

public class SystemStatusInfo {
    /**
     * 系统名称
     */
    private String name;
    /**
     * 分析对象名称
     */
    private String objectName;
    /**
     * 架构 x86/64
     */
    private String arch;
    /**
     * 分析对象类名
     */
    private String clazz;
    /**
     * 操作系统版本
     */
    private String version;

    /**
     * Java虚拟机的可用的处理器数量
     */
    private Integer availableProcessors;

    /**
     * 可用虚拟内存（字节）
     */
    private Long freeSwapSpaceSize;
    /**
     * 虚拟内存总量（字节）
     */
    private Long totalSwapSpaceSize;

    /**
     * 可用物理内存（字节）
     */
    private Long freePhysicalMemorySize;
    /**
     * 物理内存总量（字节）
     */
    private Long totalPhysicalMemorySize;
    /**
     * 保证对正在运行的进程可用的虚拟内存量，单位以字节表示，如果不支持此操作，则返回-1
     */
    private Long committedVirtualMemorySize;

    /**
     * 进程CPU占用率
     */
    private Double processCpuLoad;
    /**
     * 系统CPU占用率
     */
    private Double systemCpuLoad;
    /**
     * 运行 Java 虚拟机的进程所使用的 CPU 时间（以纳秒为单位）
     */
    private Long processCpuTime;

    /**
     * 最后一分钟的系统平均负载
     */
    private Double systemLoadAverage;

    /**
     * 信息获取花费时间（毫秒）
     */
    private Long spendTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getArch() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getAvailableProcessors() {
        return availableProcessors;
    }

    public void setAvailableProcessors(Integer availableProcessors) {
        this.availableProcessors = availableProcessors;
    }

    public Long getFreeSwapSpaceSize() {
        return freeSwapSpaceSize;
    }

    public void setFreeSwapSpaceSize(Long freeSwapSpaceSize) {
        this.freeSwapSpaceSize = freeSwapSpaceSize;
    }

    public Long getTotalSwapSpaceSize() {
        return totalSwapSpaceSize;
    }

    public void setTotalSwapSpaceSize(Long totalSwapSpaceSize) {
        this.totalSwapSpaceSize = totalSwapSpaceSize;
    }

    public Long getFreePhysicalMemorySize() {
        return freePhysicalMemorySize;
    }

    public void setFreePhysicalMemorySize(Long freePhysicalMemorySize) {
        this.freePhysicalMemorySize = freePhysicalMemorySize;
    }

    public Long getTotalPhysicalMemorySize() {
        return totalPhysicalMemorySize;
    }

    public void setTotalPhysicalMemorySize(Long totalPhysicalMemorySize) {
        this.totalPhysicalMemorySize = totalPhysicalMemorySize;
    }

    public Long getCommittedVirtualMemorySize() {
        return committedVirtualMemorySize;
    }

    public void setCommittedVirtualMemorySize(Long committedVirtualMemorySize) {
        this.committedVirtualMemorySize = committedVirtualMemorySize;
    }

    public Double getProcessCpuLoad() {
        return processCpuLoad;
    }

    public void setProcessCpuLoad(Double processCpuLoad) {
        this.processCpuLoad = processCpuLoad;
    }

    public Double getSystemCpuLoad() {
        return systemCpuLoad;
    }

    public void setSystemCpuLoad(Double systemCpuLoad) {
        this.systemCpuLoad = systemCpuLoad;
    }

    public Long getProcessCpuTime() {
        return processCpuTime;
    }

    public void setProcessCpuTime(Long processCpuTime) {
        this.processCpuTime = processCpuTime;
    }

    public Double getSystemLoadAverage() {
        return systemLoadAverage;
    }

    public void setSystemLoadAverage(Double systemLoadAverage) {
        this.systemLoadAverage = systemLoadAverage;
    }

    public Long getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Long spendTime) {
        this.spendTime = spendTime;
    }

    @Override
    public String toString() {
        return "SystemStatusInfo{" +
                "name='" + name + '\'' +
                ", objectName='" + objectName + '\'' +
                ", arch='" + arch + '\'' +
                ", clazz='" + clazz + '\'' +
                ", version='" + version + '\'' +
                ", availableProcessors=" + availableProcessors +
                ", freeSwapSpaceSize=" + freeSwapSpaceSize +
                ", totalSwapSpaceSize=" + totalSwapSpaceSize +
                ", freePhysicalMemorySize=" + freePhysicalMemorySize +
                ", totalPhysicalMemorySize=" + totalPhysicalMemorySize +
                ", committedVirtualMemorySize=" + committedVirtualMemorySize +
                ", processCpuLoad=" + processCpuLoad +
                ", systemCpuLoad=" + systemCpuLoad +
                ", processCpuTime=" + processCpuTime +
                ", systemLoadAverage=" + systemLoadAverage +
                ", spendTime=" + spendTime +
                '}';
    }
}
