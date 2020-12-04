package pers.yuzhyn.azylee.study.stta.jmhdemo;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * <p>Title: BenchDemo</p>
 * <p>Description:
 * <P>Program: javatraining
 * <P>Copyright:histone.com
 *
 * @author Ma Yinghui
 * @date 2019-12-18 10:21
 */
public class BenchDemo {
    ArrayList<Integer> arrayList;
    LinkedList<Integer> linkedList;
    int n;
    int batchCount;

    public BenchDemo(int n, int batchCount) {
        this.n = n;
        this.batchCount = batchCount;
    }

    public static void main(String[] args) {
        BenchDemo benchDemo = new BenchDemo(100000, 10000000);
        benchDemo.setUp();
        benchDemo.benchMark(benchDemo.new TestArray());
//        benchDemo.benchMark(benchDemo.new TestLink());
    }

    public void setUp() {
        arrayList = new ArrayList<>(n);
        linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    public void benchMark(TestTarget testTarget) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < batchCount; i++) {
            testTarget.run();
        }
        long end = System.currentTimeMillis();
        System.out.printf("test %s n =%d , batchcount = %d , time = %d ms ", testTarget.getName(), n, batchCount, end - start);
        System.out.println("\n");
    }


    interface TestTarget {
        void run();

        String getName();
    }

    public final class TestArray implements TestTarget {

        @Override
        public void run() {
            for (int i = 0; i < n; i++) {
                arrayList.get(i);
            }
        }

        @Override
        public String getName() {
            return "Array";
        }
    }

    public final class TestLink implements TestTarget {
        @Override
        public void run() {
            for (int i = 0; i < n; i++) {
                linkedList.get(i);
            }
        }
        @Override
        public String getName() {
            return "Linklist";
        }
    }
}
