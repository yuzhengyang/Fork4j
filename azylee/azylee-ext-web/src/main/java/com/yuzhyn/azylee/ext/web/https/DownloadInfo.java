package com.yuzhyn.azylee.ext.web.https;

public class DownloadInfo {
    int progress;
    double speed;
    long remainingSeconds;

    DownloadInfo(int progress, double speed, long remainingSeconds) {
        this.progress = progress;
        this.speed = speed;
        this.remainingSeconds = remainingSeconds;
    }
}
