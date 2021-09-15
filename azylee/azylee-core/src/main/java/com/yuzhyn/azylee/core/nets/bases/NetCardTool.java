package com.yuzhyn.azylee.core.nets.bases;

import com.yuzhyn.azylee.core.logs.Alog;

import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class NetCardTool {

    public static List<NetworkInterface> getInterfaces() {
        try {
            List<NetworkInterface> interfaces = new ArrayList<>();
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                } else {
                    interfaces.add(netInterface);
                }
            }
            return interfaces;
        } catch (Exception e) {
            Alog.e(e.getMessage());
        }
        return null;
    }
}
