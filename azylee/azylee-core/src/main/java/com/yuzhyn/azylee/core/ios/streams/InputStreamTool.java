package com.yuzhyn.azylee.core.ios.streams;

import com.yuzhyn.azylee.core.logs.Alog;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamTool {

    /**
     * 数据流关闭（不建议使用）
     * 建议参考：try-with-resource处理机制
     *
     * @param stream 参数
     */
    @Deprecated
    public static void forceClose(InputStream stream) {
        try {
            if (stream != null) {
                stream.close();
            }
        } catch (IOException e) {
            Alog.e(e.getMessage());
        }
    }
}
