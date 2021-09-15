package com.yuzhyn.azylee.core.nets.bases;

import com.yuzhyn.azylee.core.logs.Alog;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class IPTool {

    public static String getIp(NetworkInterface netInterface) {
        String ip = null;
        try {
            if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {

            } else {
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                InetAddress address = null;
                while (addresses.hasMoreElements()) {
                    address = addresses.nextElement();
                    if (address != null && address instanceof Inet4Address) {
                        ip = address.getHostAddress();
                        Alog.i(ip);
                        Alog.i(address.getHostAddress());
                    }
                }
            }
        } catch (Exception ex) {
            Alog.e(ex.getMessage());
        }
        return ip;
    }

//    public static void main(String[] args) {
//        List<NetworkInterface> list = NetCardTool.getInterfaces();
//        if(ListTool.ok(list)){
//            for(NetworkInterface item : list){
//                Log.i(IPTool.getIp(item));
//            }
//        }
//    }
}
