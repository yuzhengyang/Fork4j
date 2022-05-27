package com.yuzhyn.azylee.core.systems.bases;

import com.yuzhyn.azylee.core.datas.collections.MapTool;
import com.yuzhyn.azylee.core.datas.strings.NameFormat;
import com.yuzhyn.azylee.core.reflects.bases.MethodTool;
import com.yuzhyn.azylee.core.systems.linuxs.status.LinuxSystemStatusTool;
import com.yuzhyn.azylee.core.systems.models.MemoryInfo;
import com.yuzhyn.azylee.core.systems.models.SystemStatusInfo;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemStatusTool {

    private static Map<String, Object> getStatusMap() {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
            Class<?> clazz = operatingSystemMXBean.getClass();
            List<Method> methods = MethodTool.getterWithoutParams(clazz.getMethods());
            for (Method item : methods) {
                try {
                    item.setAccessible(true);
                    Object value = item.invoke(operatingSystemMXBean);
                    String key = item.getName();
                    key = key.substring(MethodTool.GETTER_PREFIX.length());
                    key = NameFormat.firstCharToLower(key);
                    resultMap.put(key, value);
                } catch (Exception ex) {
                }
            }
        } catch (Exception ex) {
        }
        return resultMap;
    }

    public static SystemStatusInfo getStatusInfo() {
        long t1 = System.currentTimeMillis();
        SystemStatusInfo statusInfo = new SystemStatusInfo();
        Map<String, Object> mapData = getStatusMap();
        statusInfo.setName(MapTool.getString(mapData, "name", ""));
        statusInfo.setObjectName(MapTool.getString(mapData, "objectName", ""));
        statusInfo.setArch(MapTool.getString(mapData, "arch", ""));
//        statusInfo.setClazz(MapTool.getString(mapData, "clazz", ""));
        statusInfo.setVersion(MapTool.getString(mapData, "version", ""));
        statusInfo.setAvailableProcessors(MapTool.getInt(mapData, "availableProcessors", 0));
        statusInfo.setFreeSwapSpaceSize(MapTool.getLong(mapData, "freeSwapSpaceSize", 0));
        statusInfo.setTotalSwapSpaceSize(MapTool.getLong(mapData, "totalSwapSpaceSize", 0));
        statusInfo.setFreePhysicalMemorySize(MapTool.getLong(mapData, "freePhysicalMemorySize", 0));
        statusInfo.setTotalPhysicalMemorySize(MapTool.getLong(mapData, "totalPhysicalMemorySize", 0));
        statusInfo.setCommittedVirtualMemorySize(MapTool.getLong(mapData, "committedVirtualMemorySize", 0));
        statusInfo.setProcessCpuLoad(MapTool.getDouble(mapData, "processCpuLoad", 0));
        statusInfo.setSystemCpuLoad(MapTool.getDouble(mapData, "systemCpuLoad", 0));
        statusInfo.setProcessCpuTime(MapTool.getLong(mapData, "processCpuTime", 0));
        statusInfo.setSystemLoadAverage(MapTool.getDouble(mapData, "systemLoadAverage", 0));
        long t2 = System.currentTimeMillis();
        statusInfo.setSpendTime(t2 - t1);
        return statusInfo;
    }

    public static float getCpuUseRatio() {
        if (SystemTypeTool.isLinux()) {
            return LinuxSystemStatusTool.getCpuUseRatio();
        }
        return 0;
    }

    public static MemoryInfo getRam() {
        if (SystemTypeTool.isLinux()) {
            return LinuxSystemStatusTool.getRam();
        }
        return new MemoryInfo();
    }

    public static void main(String[] args) {

        SystemStatusInfo statusInfo = getStatusInfo();

        for (int i = 0; i < 2; i++) {
            long t1 = System.currentTimeMillis();
            Map<String, Object> data = getStatusMap();
            for (String key : data.keySet()) {
                System.out.println("key: " + key + ", value: " + data.get(key));
            }
            long t2 = System.currentTimeMillis();
            long sp = t2 - t1;
            System.out.println("sp: " + sp);
        }
    }
}
