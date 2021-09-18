package com.yuzhyn.azylee.websdk.args;

import com.yuzhyn.azylee.core.datas.ids.SnowFlake;
import com.yuzhyn.azylee.core.ios.dirs.DirTool;
import com.yuzhyn.azylee.core.systems.commons.SystemPropertyTool;
import com.yuzhyn.azylee.websdk.model.logs.WebAccessLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class WebSdk {

    /**
     * WebSdk 是否初始化执行
     */
    static boolean isRun = false;

    static String appName = "";

    static String WebSdkDataFolder = "websdk-data";

    static String city;

    @Value("${spring.application.city:undefined}")
    public void setCity(String city) {
        WebSdk.city = city;
    }


//    @Value("${spring.application.name:un}")
//    public void setAppName(String appName) {
//        System.out.println("@Value 加载配置文件数据 appName");
//        AppInfo.appName = appName;
//
//        try {
//            DirTool.create(R.Paths.Database());
//            DirTool.create(R.Paths.TempDir());
//            DirTool.create(R.Paths.SysFile());
//            DirTool.create(R.Paths.SysFileTemp());
//        } catch (Exception ex) {
//        }
//    }


    static long RunTimes = 0;
    static int DataCenterId = 0;
    static int WorkerId = 0;
    static String _MachineId = "";

    public static String MachineId() {
        return _MachineId;
    }

    public static SnowFlake SnowFlake = new SnowFlake(DataCenterId, WorkerId);
    public static final LocalDateTime StartTime = LocalDateTime.now();

    public static LocalDateTime Today() {
        return LocalDateTime.now();
    }

    public static class Paths {
        public static final String App = SystemPropertyTool.userDir();
        public static final String AppData = DirTool.combine(App, WebSdkDataFolder);
        public static final String Properties = DirTool.combine(AppData, "properties");
        public static final String Database = DirTool.combine(AppData, "database");
        public static final String Temp = DirTool.combine(AppData, "temp");
        public static final String TempDir = DirTool.combine(AppData, "tempdir");
        public static final String SysFile = DirTool.combine(AppData, "sysfile");
        public static final String SysFileTemp = DirTool.combine(SysFile, "temp");
    }

    public static class Files {
        public static final String App = "x";
        public static final String AppInfo = DirTool.combine(Paths.Properties, "app_info.properties");
        public static final String MachineInfo = DirTool.combine(Paths.Properties, "machine_info.properties");
        public static final String AccessInfo = DirTool.combine(Paths.Properties, "access_info.properties");
        public static final String StatusInfo = DirTool.combine(Paths.Properties, "status_info.properties");
        public static final String MainDbFile = DirTool.combine(Paths.Database, "hiops_main_db.sqlite3");
    }


    public static class Queue {
        public static ConcurrentLinkedQueue<WebAccessLog> WebAccessLogs = new ConcurrentLinkedQueue<>();
    }
}
