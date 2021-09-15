package com.yuzhyn.azylee.core.systems.models;

public class MemoryInfo {
    private long MemTotal;
    private long MemFree;
    private long SwapTotal;
    private long SwapFree;

    public long getMemTotal() {
        return MemTotal;
    }

    public void setMemTotal(long memTotal) {
        MemTotal = memTotal;
    }

    public long getMemFree() {
        return MemFree;
    }

    public void setMemFree(long memFree) {
        MemFree = memFree;
    }

    public long getSwapTotal() {
        return SwapTotal;
    }

    public void setSwapTotal(long swapTotal) {
        SwapTotal = swapTotal;
    }

    public long getSwapFree() {
        return SwapFree;
    }

    public void setSwapFree(long swapFree) {
        SwapFree = swapFree;
    }

    @Override
    public String toString() {
        return "MemoryInfo{" +
                "MemTotal=" + MemTotal +
                ", MemFree=" + MemFree +
                ", SwapTotal=" + SwapTotal +
                ", SwapFree=" + SwapFree +
                '}';
    }
}
