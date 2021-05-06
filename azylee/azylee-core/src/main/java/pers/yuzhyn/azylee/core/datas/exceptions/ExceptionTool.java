package pers.yuzhyn.azylee.core.datas.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionTool {

    /**
     * 获取异常堆栈信息
     * @param e
     * @return
     */
    public static String getStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            e.printStackTrace(pw);
            return sw.toString();
        } catch (Exception e1) {
            return "";
        }
    }

}
