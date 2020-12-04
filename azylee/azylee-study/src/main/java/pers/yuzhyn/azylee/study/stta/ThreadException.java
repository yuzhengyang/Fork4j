package pers.yuzhyn.azylee.study.stta;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/**
 * <p>Title: ThreadException</p>
 * <p>Description:多线程异常吞噬和异常泄露
 * <P>Program: javatraining
 * <P>Copyright:histone.com
 *
 * @author Ma Yinghui
 * @date 2019-12-02 23:35
 */
public class ThreadException {
    public static void main(String[] args) throws Exception {
        Runnable runnable = () -> {int a = 1 / 0;};
        final ExecutorService executorService = Executors.newFixedThreadPool(1, new MyThreadFactory((t, e) -> {
            System.out.println(t.toString() + ": I catch it in handler thread");
            System.err.println(e.getMessage());
        }));
        try {
           Future f = executorService.submit(runnable);
           f.get();
        } catch (Exception e) {
            //跑不到这里。
            System.out.println("I catch it in main thread");
            e.printStackTrace();
        }

    }
    private static class MyThreadFactory implements ThreadFactory {
        private Thread.UncaughtExceptionHandler handler;
        MyThreadFactory(Thread.UncaughtExceptionHandler handler) {
            this.handler = handler;
        }
        public Thread newThread(Runnable var1) {
            Thread thread = new Thread(var1);
            thread.setName("ExeceptionThread");
            thread.setUncaughtExceptionHandler(handler);
            return thread;
        }
    }


    interface A {
        void a() throws Exception ;
    }
    class B implements A {

        @Override
        public void a() throws ArithmeticException,InterruptedException {

        }
    }
}
