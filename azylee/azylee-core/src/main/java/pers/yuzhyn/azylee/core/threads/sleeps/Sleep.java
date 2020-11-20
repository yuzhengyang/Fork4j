package pers.yuzhyn.azylee.core.threads.sleeps;

/**
 * 睡眠等待
 * @author inc
 */
public class Sleep {
    /**
     * 等待（秒）
     * @param second
     */
    public static void s(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
        }
    }

    /**
     * 等待（分钟）
     * @param minute
     */
    public static void m(long minute) {
        try {
            Thread.sleep(minute * 60 * 1000);
        } catch (InterruptedException e) {
        }
    }
}
