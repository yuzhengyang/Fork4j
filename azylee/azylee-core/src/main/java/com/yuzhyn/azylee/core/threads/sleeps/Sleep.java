package com.yuzhyn.azylee.core.threads.sleeps;

/**
 * 睡眠等待
 * @author inc
 */
public class Sleep {
    /**
     * 等待（毫秒）
     * @param millis 参数
     */
    public static void ms(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

    /**
     * 等待（秒）
     * @param second 参数
     */
    public static void s(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
        }
    }

    /**
     * 等待（分钟）
     * @param minute 参数
     */
    public static void m(long minute) {
        try {
            Thread.sleep(minute * 60 * 1000);
        } catch (InterruptedException e) {
        }
    }
}
