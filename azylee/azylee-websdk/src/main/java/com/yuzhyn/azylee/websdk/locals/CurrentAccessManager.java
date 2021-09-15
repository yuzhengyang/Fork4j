package com.yuzhyn.azylee.websdk.locals;

import com.yuzhyn.azylee.websdk.model.logs.WebAccessLog;

public class CurrentAccessManager {

    private static ThreadLocal<Boolean> Access = ThreadLocal.withInitial(() -> false);
    private static ThreadLocal<WebAccessLog> webAccessLog = ThreadLocal.withInitial(() -> null);

    public static boolean isAccess() {
        boolean ac = Access.get();
        WebAccessLog lg = webAccessLog.get();
        return ac && lg != null;
    }

    public static WebAccessLog getWebAccessLog() {
        if (isAccess()) {
            return webAccessLog.get();
        }
        return null;
    }

    public static void set(WebAccessLog sysAccessLog) {
        if (sysAccessLog != null) {
            CurrentAccessManager.webAccessLog.set(sysAccessLog);
            CurrentAccessManager.Access.set(true);
        }
    }

    public static void clear() {
        CurrentAccessManager.webAccessLog.remove();
    }
}