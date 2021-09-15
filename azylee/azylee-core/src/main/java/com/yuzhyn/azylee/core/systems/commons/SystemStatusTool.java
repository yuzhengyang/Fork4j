package com.yuzhyn.azylee.core.systems.commons;

import com.yuzhyn.azylee.core.systems.models.MemoryInfo;
import com.yuzhyn.azylee.core.systems.linuxs.status.LinuxSystemStatusTool;

public class SystemStatusTool {

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
}
