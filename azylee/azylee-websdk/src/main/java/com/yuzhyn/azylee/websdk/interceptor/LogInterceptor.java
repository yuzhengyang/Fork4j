package com.yuzhyn.azylee.websdk.interceptor;


import com.yuzhyn.azylee.core.datas.exceptions.ExceptionTool;
import com.yuzhyn.azylee.core.datas.strings.StringTool;
import com.yuzhyn.azylee.websdk.args.WebSdk;
import com.yuzhyn.azylee.websdk.config.sdks.WebAccessLogConfig;
import com.yuzhyn.azylee.websdk.locals.CurrentAccessManager;
import com.yuzhyn.azylee.websdk.locals.CurrentUserManager;
import com.yuzhyn.azylee.websdk.model.logs.WebAccessLog;
import com.yuzhyn.azylee.websdk.utils.http.ClientIPTool;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 访问信息拦截器
 */
@Component
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

        if (WebAccessLogConfig.enable) {

            printLog("LogInterceptor: afterCompletion");

            updateLog("afterCompletion", arg3);
        }
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub

        if (WebAccessLogConfig.enable) {
            printLog("LogInterceptor: postHandle");

            updateLog("postHandle", null);
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {


        if (WebAccessLogConfig.enable) {
            printLog("LogInterceptor: preHandle");

            createLog("preHandle", request);
        }

        return true;
    }

    // 获取请求数据信息
    // https://blog.csdn.net/cold___play/article/details/100920952

    public void printLog(String s) {
        if (WebAccessLogConfig.printlog) {
            System.out.println(s);
        }
    }

    /**
     * 记录请求日志
     *
     * @param request 参数
     */
    private void createLog(String step, HttpServletRequest request) {
        try {
            Thread currentThread = Thread.currentThread();

            WebAccessLog sysAccessLog = new WebAccessLog();
            sysAccessLog.setId(WebSdk.SnowFlake.nexts());
            sysAccessLog.setIp(ClientIPTool.getIp(request));
            sysAccessLog.setBeginTime(LocalDateTime.now());
            sysAccessLog.setEndTime(null);
            sysAccessLog.setUri(URLDecoder.decode(request.getRequestURI(), "utf-8"));
            sysAccessLog.setMethod(request.getMethod());
            sysAccessLog.setElapsedTime(0L);
            if (CurrentUserManager.isLogin()) {
                sysAccessLog.setUserId(CurrentUserManager.getUser().getId());
            }
            sysAccessLog.setStep(step);
            sysAccessLog.setThreadName(currentThread.getName());
            sysAccessLog.setException("");

            Runtime runtime = Runtime.getRuntime();
            sysAccessLog.setBeginMaxMemory(runtime.maxMemory());
            sysAccessLog.setBeginTotalMemory(runtime.totalMemory());
            sysAccessLog.setBeginFreeMemory(runtime.freeMemory());

            CurrentAccessManager.set(sysAccessLog);
            WebSdk.Queue.WebAccessLogs.add(sysAccessLog);
        } catch (Exception ex) {
        }
    }

    private void updateLog(String step, Exception exception) {
        try {
            if (CurrentAccessManager.isAccess()) {
                Thread currentThread = Thread.currentThread();

                WebAccessLog sysAccessLog = CurrentAccessManager.getWebAccessLog();
                sysAccessLog.setEndTime(LocalDateTime.now());

                if (sysAccessLog.getBeginTime() != null && sysAccessLog.getEndTime() != null) {
                    Duration duration = Duration.between(sysAccessLog.getBeginTime(), sysAccessLog.getEndTime());
                    sysAccessLog.setElapsedTime(duration.toMillis());
                }

                if (StringTool.ok(sysAccessLog.getThreadName()) && !sysAccessLog.getThreadName().equals(currentThread.getName())) {
                    sysAccessLog.setThreadName(sysAccessLog.getThreadName() + " -> " + currentThread.getName());
                } else {
                    sysAccessLog.setThreadName(currentThread.getName());
                }

                if (exception != null) {
                    sysAccessLog.setException(ExceptionTool.getStackTrace(exception));
                }
                sysAccessLog.setStep(sysAccessLog.getStep() + " -> " + step);

                Runtime runtime = Runtime.getRuntime();
                sysAccessLog.setEndMaxMemory(runtime.maxMemory());
                sysAccessLog.setEndTotalMemory(runtime.totalMemory());
                sysAccessLog.setEndFreeMemory(runtime.freeMemory());

                if (sysAccessLog.getBeginFreeMemory() != null && sysAccessLog.getEndFreeMemory() != null) {
                    sysAccessLog.setProbablyUseMemory(sysAccessLog.getBeginFreeMemory() - sysAccessLog.getEndFreeMemory());
                }

                WebSdk.Queue.WebAccessLogs.add(sysAccessLog);
                CurrentAccessManager.clear();
            }

        } catch (Exception ex) {
        }
    }
}