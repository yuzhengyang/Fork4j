package com.yuzhyn.azylee.websdk.args;

import com.yuzhyn.azylee.core.datas.collections.MapTool;
import com.yuzhyn.azylee.core.datas.datetimes.DateTimeFormat;
import com.yuzhyn.azylee.core.datas.ids.SnowFlake;
import com.yuzhyn.azylee.core.datas.ids.UUIDTool;
import com.yuzhyn.azylee.core.datas.numbers.LongTool;
import com.yuzhyn.azylee.core.datas.strings.StringConst;
import com.yuzhyn.azylee.core.datas.strings.StringTool;
import com.yuzhyn.azylee.core.ios.dirs.DirTool;
import com.yuzhyn.azylee.core.ios.txts.PropertyTool;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * WebSdk
 */
public class WebSdkStarter {

    public static void init(String appName) {

        if(StringTool.ok(appName)){
            WebSdk.appName = appName;
            WebSdk.WebSdkDataFolder = WebSdk.appName  + "-websdk-data";
        }

        // ******
        System.out.println("** 创建文件夹 **");
        DirTool.create(WebSdk.Paths.Database);
        DirTool.create(WebSdk.Paths.TempDir);
        DirTool.create(WebSdk.Paths.Temp);
        DirTool.create(WebSdk.Paths.SysFile);
        DirTool.create(WebSdk.Paths.SysFileTemp);
//        log.info("** 设置临时文件目录（不建议使用，会造成大量垃圾文件） **");
//        System.setProperty("java.io.tmpdir", R.Paths.TempDir);

        // ******


        System.out.println("********** 初始化配置信息 **********");
        {
            System.out.println("** 配置信息：MachineInfo **");
            // 读取
            Map<String, String> machineProps = PropertyTool.read(WebSdk.Files.MachineInfo);
            WebSdk._MachineId = MapTool.get(machineProps, "machine_id", "");
            if (!StringTool.ok(WebSdk._MachineId)) WebSdk._MachineId = UUIDTool.get();
            // 写出
            machineProps.put("machine_id", WebSdk._MachineId);
            machineProps.put("desc", "设备信息");
            machineProps.put("update_time", DateTimeFormat.toStr(LocalDateTime.now()));
            PropertyTool.write(WebSdk.Files.MachineInfo, machineProps);
        }

        {
            System.out.println("** 配置信息：app **");
            // 读取
            Map<String, String> appProps = PropertyTool.read(WebSdk.Files.AppInfo);
            WebSdk.RunTimes = LongTool.parseFromInts(MapTool.get(appProps, "run_times", "0"), 0);
            // 写出
            appProps.put("run_times", String.valueOf(WebSdk.RunTimes + 1));
            appProps.put("desc", "程序信息");
            appProps.put("update_time", DateTimeFormat.toStr(LocalDateTime.now()));
            PropertyTool.write(WebSdk.Files.AppInfo, appProps);
        }
    }

    /**
     * 启用功能
     *
     * @param dataCenterId 参数
     * @param workerId 参数
     */
    public static void run(int dataCenterId, int workerId) throws Exception {

        if (dataCenterId < 0 || workerId < 0) {
            String msg = StringConst.NEWLINE +
                    "中断启动：" +
                    "DataCenterId 和 WorkerId 未设置" +
                    "这将影响 SnowFlake 生成ID序号" +
                    StringConst.NEWLINE +
                    "解决方法：" +
                    "查看数据库 sys_machine 表，设置 data_center_id 和 worker_id 字段，" +
                    "取值范围：[0,31] [0,31] 包含两端";
            System.out.println(msg);
            throw new Exception(msg);
        }

        WebSdk.DataCenterId = dataCenterId;
        WebSdk.WorkerId = workerId;
        WebSdk.SnowFlake = new SnowFlake(WebSdk.DataCenterId, WebSdk.WorkerId);


        WebSdk.isRun = true;
        System.out.println("WebSdk 启用完成");
    }
}
