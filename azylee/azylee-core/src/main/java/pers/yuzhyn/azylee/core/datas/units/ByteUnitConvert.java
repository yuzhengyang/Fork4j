package pers.yuzhyn.azylee.core.datas.units;

public class ByteUnitConvert {

    /**
     * 自动格式化字节单位
     *
     * @param size
     * @param digits
     * @return
     */
    public static String fmt(long size, int digits) {
        return fmt((double) size, digits);
    }

    /**
     * 自动格式化字节单位
     *
     * @param size
     * @param digits
     * @return
     */
    public static String fmt(double size, int digits) {
        String rs = "";
        String fmtString = "%." + digits + "f";
        if (size >= ByteUnitConst.TB) {
            rs = String.format(fmtString, size / ByteUnitConst.TB) + " TB";
        } else if (size >= ByteUnitConst.GB) {
            rs = String.format(fmtString, size / ByteUnitConst.GB) + " GB";
        } else if (size >= ByteUnitConst.MB) {
            rs = String.format(fmtString, size / ByteUnitConst.MB) + " MB";
        } else if (size >= ByteUnitConst.KB) {
            rs = String.format(fmtString, size / ByteUnitConst.KB) + " KB";
        } else {
            rs = size + " B";
        }
        return rs;
    }

    /**
     * 根据单位换算
     *
     * @param size
     * @param unit
     * @return
     */
    public static double cvt(long size, String unit) {
        return cvt((double) size, unit);
    }

    /**
     * 根据单位换算
     *
     * @param size
     * @param unit
     * @return
     */
    public static double cvt(double size, String unit) {
        switch (unit) {
            case "KB":
                return size / ByteUnitConst.KB;
            case "MB":
                return size / ByteUnitConst.MB;
            case "GB":
                return size / ByteUnitConst.GB;
            case "TB":
                return size / ByteUnitConst.TB;
            default:
                return size;
        }
    }
}
