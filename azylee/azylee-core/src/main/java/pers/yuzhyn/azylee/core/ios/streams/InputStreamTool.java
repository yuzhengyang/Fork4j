package pers.yuzhyn.azylee.core.ios.streams;

import pers.yuzhyn.azylee.core.logs.Alog;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamTool {

    /**
     * 数据流关闭（不建议使用）
     * 建议参考：try-with-resource处理机制
     *
     * @param stream
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
