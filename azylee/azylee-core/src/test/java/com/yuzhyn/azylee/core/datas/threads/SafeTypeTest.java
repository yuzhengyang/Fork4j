package com.yuzhyn.azylee.core.datas.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class SafeTypeTest {

    public static AtomicInteger times;

    public static void main(String[] args) {
        times = new AtomicInteger();
        times.getAndAdd(3);
        System.out.println(times.get());
    }
}
