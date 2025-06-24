/**
 * 导出包信息
 */
open module com.yuzhyn.azylee.core {
    requires java.sql;
    requires java.management;
    requires java.datatransfer;
    requires java.desktop;

    // 导出 com.yuzhyn.azylee.core.datas 路径下所有模块
    exports com.yuzhyn.azylee.core.datas.collections;
//    exports com.yuzhyn.azylee.core.datas.consts;
    exports com.yuzhyn.azylee.core.datas.datetimes;
    exports com.yuzhyn.azylee.core.datas.encrypts;
    exports com.yuzhyn.azylee.core.datas.exceptions;
    exports com.yuzhyn.azylee.core.datas.ids;
    exports com.yuzhyn.azylee.core.datas.keyvalues;
    exports com.yuzhyn.azylee.core.datas.numbers;
    exports com.yuzhyn.azylee.core.datas.objects;
    exports com.yuzhyn.azylee.core.datas.regexs;
    exports com.yuzhyn.azylee.core.datas.strings;
    exports com.yuzhyn.azylee.core.datas.units;

    // 导出 com.yuzhyn.azylee.core.ios 路径下所有模块
//    exports com.yuzhyn.azylee.core.ios.buffers;
    exports com.yuzhyn.azylee.core.ios.dirs;
    exports com.yuzhyn.azylee.core.ios.files;
    exports com.yuzhyn.azylee.core.ios.imgs;
    exports com.yuzhyn.azylee.core.ios.streams;
    exports com.yuzhyn.azylee.core.ios.txts;
    exports com.yuzhyn.azylee.core.ios.zips;

    exports com.yuzhyn.azylee.core.systems.toasts;
    exports com.yuzhyn.azylee.core.threads.sleeps;

    exports com.yuzhyn.azylee.core.systems.bases;
    exports com.yuzhyn.azylee.core.logs;
}