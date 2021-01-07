package pers.yuzhyn.azylee.core.ios.files;

import pers.yuzhyn.azylee.core.datas.strings.StringTool;
import pers.yuzhyn.azylee.core.logs.Log;

public class FileTypeTool {

    public static FileTypeEnum getType(String fileName) {
        if (StringTool.ok(fileName)) {
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toUpperCase();

            for (FileTypeEnum type : FileTypeEnum.values()) {
                for (int i = 0; i < type.getExts().length; i++) {
                    if (type.getExts()[i].equals(fileType)) {
                        return type;
                    }
                }
            }
        }
        return FileTypeEnum.UNKNOWN;
    }

//    public static void main(String[] args) {
//        Log.i(FileTypeTool.getType("").getDesc());
//        Log.i(FileTypeTool.getType("d:/tmp/t1.txt").getDesc());
//        Log.i(FileTypeTool.getType("d:/tmp/t2").getDesc());
//        Log.i(FileTypeTool.getType("d:/tmp/t3.txt.sql").getDesc());
//    }
}
