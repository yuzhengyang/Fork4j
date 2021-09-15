package com.yuzhyn.azylee.core.datas.ids;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IdWorkerTest {


    /**
     * main 测试类
     *
     * @param args
     */
    public static void main(String[] args) {

        BigDecimal a = new BigDecimal(0.2);
        BigDecimal b = new BigDecimal(5);

        BigDecimal c = a.divide(b).setScale(2, RoundingMode.HALF_UP);
        System.out.println(c);

        if(a.compareTo(BigDecimal.ZERO) == 0){
            System.out.println("为零");
        }

//        System.out.println(1&4596);
//        System.out.println(2&4596);
//        System.out.println(6&4596);
//        System.out.println(6&4596);
//        System.out.println(6&4596);
//        System.out.println(6&4596);
//        SnowFlake worker = new SnowFlake(1,1,1);
//        for (int i = 0; i < 22; i++) {
//            System.out.println(worker.nexts());
//        }
    }
}
