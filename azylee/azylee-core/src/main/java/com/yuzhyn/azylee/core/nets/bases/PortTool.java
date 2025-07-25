package com.yuzhyn.azylee.core.nets.bases;

import java.io.IOException;
import java.net.Socket;

public class PortTool {
    public static boolean isOpen(String host, int port) {
        try (Socket socket = new Socket()) {
            // 尝试连接到指定主机和端口，超时时间设置为 2000 毫秒
            socket.connect(new java.net.InetSocketAddress(host, port), 2000);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
