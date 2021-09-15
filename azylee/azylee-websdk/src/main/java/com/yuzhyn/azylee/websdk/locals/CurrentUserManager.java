package com.yuzhyn.azylee.websdk.locals;

import com.yuzhyn.azylee.core.logs.Alog;
import com.yuzhyn.azylee.websdk.model.users.UserFileConf;
import com.yuzhyn.azylee.websdk.model.users.UserInfo;

public class CurrentUserManager {

    private static ThreadLocal<Boolean> login = ThreadLocal.withInitial(() -> false);
    private static ThreadLocal<String> token = ThreadLocal.withInitial(() -> null);
    private static ThreadLocal<UserInfo> user = ThreadLocal.withInitial(() -> null);
    private static ThreadLocal<UserFileConf> fileConfig = ThreadLocal.withInitial(() -> null);

    public static boolean isLogin() {
        return login.get() && user != null;
    }

    public static String getToken() {
        return token.get();
    }

    public static UserInfo getUser() {
        return user.get();
    }

    public static UserFileConf getFileConfig() {
        return fileConfig.get();
    }

    public static void set(String token, UserInfo userInfo, UserFileConf userFileConf) {
        Alog.i("Thread.currentThread: " + Thread.currentThread());
        if (token != null) {
            CurrentUserManager.token.set(token);
            login.set(true);
        }
        if (userInfo != null) CurrentUserManager.user.set(userInfo);
        if (userFileConf != null) CurrentUserManager.fileConfig.set(userFileConf);
    }

    public static void clearCurrentUser() {
        CurrentUserManager.login.remove();
        CurrentUserManager.token.remove();
        CurrentUserManager.user.remove();
        CurrentUserManager.fileConfig.remove();
    }
}
