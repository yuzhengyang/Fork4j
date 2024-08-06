package com.yuzhyn.azylee.core.datas.ios;

import com.yuzhyn.azylee.core.ios.dirs.DirTool;
import com.yuzhyn.azylee.core.logs.Alog;

public class DirToolTest {
    public static void main(String[] args) {
        String src = "D:\\temp\\src\\sysinternalssuite";
        String tgt = "D:\\temp\\tgt\\sysinternalssuite";
        boolean moveFlag = DirTool.move(src, tgt);
        Alog.i("move flag: " + moveFlag);
    }
}
