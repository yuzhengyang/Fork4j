package com.yuzhyn.azylee.core.systems.commons;

/**
 * 系统类型检查工具
 */
public class SystemTypeTool {

    private static String OS = System.getProperty("os.name").toLowerCase();

    private static SystemTypeTool _instance = new SystemTypeTool();

    private SystemType platform;

    private SystemTypeTool() {
    }

    public static boolean isLinux() {
        return OS.indexOf("linux") >= 0;
    }

    public static boolean isMacOS() {
        return OS.indexOf("mac") >= 0 && OS.indexOf("os") > 0 && OS.indexOf("x") < 0;
    }

    public static boolean isMacOSX() {
        return OS.indexOf("mac") >= 0 && OS.indexOf("os") > 0 && OS.indexOf("x") > 0;
    }

    public static boolean isWindows() {
        return OS.indexOf("windows") >= 0;
    }

    public static boolean isOS2() {
        return OS.indexOf("os/2") >= 0;
    }

    public static boolean isSolaris() {
        return OS.indexOf("solaris") >= 0;
    }

    public static boolean isSunOS() {
        return OS.indexOf("sunos") >= 0;
    }

    public static boolean isMPEiX() {
        return OS.indexOf("mpe/ix") >= 0;
    }

    public static boolean isHPUX() {
        return OS.indexOf("hp-ux") >= 0;
    }

    public static boolean isAix() {
        return OS.indexOf("aix") >= 0;
    }

    public static boolean isOS390() {
        return OS.indexOf("os/390") >= 0;
    }

    public static boolean isFreeBSD() {
        return OS.indexOf("freebsd") >= 0;
    }

    public static boolean isIrix() {
        return OS.indexOf("irix") >= 0;
    }

    public static boolean isDigitalUnix() {
        return OS.indexOf("digital") >= 0 && OS.indexOf("unix") > 0;
    }

    public static boolean isNetWare() {
        return OS.indexOf("netware") >= 0;
    }

    public static boolean isOSF1() {
        return OS.indexOf("osf1") >= 0;
    }

    public static boolean isOpenVMS() {
        return OS.indexOf("openvms") >= 0;
    }

    /**
     * 获取操作系统名字
     *
     * @return 操作系统名
     */
    public static SystemType getOSname() {
        if (isAix()) {
            _instance.platform = SystemType.AIX;
        } else if (isDigitalUnix()) {
            _instance.platform = SystemType.Digital_Unix;
        } else if (isFreeBSD()) {
            _instance.platform = SystemType.FreeBSD;
        } else if (isHPUX()) {
            _instance.platform = SystemType.HP_UX;
        } else if (isIrix()) {
            _instance.platform = SystemType.Irix;
        } else if (isLinux()) {
            _instance.platform = SystemType.Linux;
        } else if (isMacOS()) {
            _instance.platform = SystemType.Mac_OS;
        } else if (isMacOSX()) {
            _instance.platform = SystemType.Mac_OS_X;
        } else if (isMPEiX()) {
            _instance.platform = SystemType.MPEiX;
        } else if (isNetWare()) {
            _instance.platform = SystemType.NetWare_411;
        } else if (isOpenVMS()) {
            _instance.platform = SystemType.OpenVMS;
        } else if (isOS2()) {
            _instance.platform = SystemType.OS2;
        } else if (isOS390()) {
            _instance.platform = SystemType.OS390;
        } else if (isOSF1()) {
            _instance.platform = SystemType.OSF1;
        } else if (isSolaris()) {
            _instance.platform = SystemType.Solaris;
        } else if (isSunOS()) {
            _instance.platform = SystemType.SunOS;
        } else if (isWindows()) {
            _instance.platform = SystemType.Windows;
        } else {
            _instance.platform = SystemType.Others;
        }
        return _instance.platform;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(SystemTypeTool.getOSname());// 获取系统类型
        System.out.println(SystemTypeTool.isWindows());// 判断是否为windows系统
    }

}