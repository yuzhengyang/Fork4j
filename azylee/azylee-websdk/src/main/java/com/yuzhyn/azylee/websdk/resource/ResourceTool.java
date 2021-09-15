package com.yuzhyn.azylee.websdk.resource;

import com.yuzhyn.azylee.core.ios.files.FileTool;
import com.yuzhyn.azylee.core.ios.files.FileVersionManager;
import com.yuzhyn.azylee.websdk.args.WebSdk;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;

public class ResourceTool {
    private static void releaseDbFile() {
//        log.info("** 释放数据库文件到外部目录 **");
        try {
            ClassPathResource classPathResource = new ClassPathResource("db/hiops_main_db.sqlite3");
            InputStream inputStream = classPathResource.getInputStream();
            FileTool.inputStreamToFile(inputStream, WebSdk.Files.MainDbFile, false);

//            log.info("** 备份数据库文件 **");
            FileVersionManager fileVersionManager = new FileVersionManager(WebSdk.Files.MainDbFile, 100);
            fileVersionManager.create();

        } catch (Exception ex) {
//            log.error("** 数据库文件释放失败，程序退出 **");
//            log.error(ex.getMessage());
        }
    }
}
