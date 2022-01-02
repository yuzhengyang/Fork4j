package com.yuzhyn.azylee.core.systems.linuxs.status;

import com.yuzhyn.azylee.core.systems.models.MemoryInfo;
import com.yuzhyn.azylee.core.threads.sleeps.Sleep;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinuxSystemStatusTool {
    /**
     * 获取CPU使用率
     * @return 返回
     */
    public static float getCpuUseRatio() {
        try {
            File file = new File("/proc/stat");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            StringTokenizer token = new StringTokenizer(br.readLine());
            token.nextToken();
            long user1 = Long.parseLong(token.nextToken());
            long nice1 = Long.parseLong(token.nextToken());
            long system1 = Long.parseLong(token.nextToken());
            long idle1 = Long.parseLong(token.nextToken());
            long iowait1 = Long.parseLong(token.nextToken());
            long irq1 = Long.parseLong(token.nextToken());
            long softirq1 = Long.parseLong(token.nextToken());

            Sleep.s(1);

            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            token = new StringTokenizer(br.readLine());
            token.nextToken();
            long user2 = Long.parseLong(token.nextToken());
            long nice2 = Long.parseLong(token.nextToken());
            long system2 = Long.parseLong(token.nextToken());
            long idle2 = Long.parseLong(token.nextToken());
            long iowait2 = Long.parseLong(token.nextToken());
            long irq2 = Long.parseLong(token.nextToken());
            long softirq2 = Long.parseLong(token.nextToken());

            // CPU在t1到t2时间段总的使用时间
            float useTime = (user2 + nice2 + system2 + idle2 + iowait2 + irq2 + softirq2) - (user1 + nice1 + system1 + idle1 + iowait1 + irq1 + softirq1);
            // CPU在t1到t2时间段空闲使用时间
            float freeTime = (idle2 - idle1);
            // CPU在t1到t2时间段即时利用率 =  1 - CPU空闲使用时间 / CPU总的使用时间
            float useRatio = 1 - freeTime / useTime;
            return useRatio;
        } catch (Exception ex) {
        }
        return 0;
    }

    /**
     * 获取内存用量数据
     * @return 返回
     */
    public static MemoryInfo getRam() {
        MemoryInfo memoryInfo = new MemoryInfo();
        try {
            File file = new File("/proc/meminfo");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String str = null, value = null;
            StringTokenizer token = null;
            while ((str = br.readLine()) != null) {
                token = new StringTokenizer(str);
                if (!token.hasMoreTokens())
                    continue;

                str = token.nextToken();
                if (!token.hasMoreTokens())
                    continue;
                else
                    value = token.nextToken();

                if (str.equalsIgnoreCase("MemTotal:"))
                    memoryInfo.setMemTotal(Long.parseLong(value));
                else if (str.equalsIgnoreCase("MemFree:"))
                    memoryInfo.setMemFree(Long.parseLong(value));
                else if (str.equalsIgnoreCase("SwapTotal:"))
                    memoryInfo.setSwapTotal(Long.parseLong(value));
                else if (str.equalsIgnoreCase("SwapFree:"))
                    memoryInfo.setSwapFree(Long.parseLong(value));

            }
        } catch (Exception ex) {
        }
        return memoryInfo;
    }
}
