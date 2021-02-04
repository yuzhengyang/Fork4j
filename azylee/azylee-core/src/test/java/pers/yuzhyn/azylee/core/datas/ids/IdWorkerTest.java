package pers.yuzhyn.azylee.core.datas.ids;

public class IdWorkerTest {


    /**
     *  main 测试类
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(1&4596);
        System.out.println(2&4596);
        System.out.println(6&4596);
        System.out.println(6&4596);
        System.out.println(6&4596);
        System.out.println(6&4596);
        SnowFlake worker = new SnowFlake(1,1,1);
        for (int i = 0; i < 22; i++) {
            System.out.println(worker.nextId());
        }
    }
}
