package com.jvm.test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

public class ForkJoinPoolTest {


    public static void main(String[] args) {
        test2();
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void test1() {
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() * 2);
        AtomicInteger i = new AtomicInteger();
        for (int j = 0; j < 1000; j++) {
            pool.submit(() -> System.out.println("i = " + i.getAndIncrement()));
        }
    }

    public static void test2() {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        AtomicInteger i = new AtomicInteger();
        for (int j = 0; j < 1000; j++) {
            pool.submit(() -> System.out.println("i = " + i.getAndIncrement()));
        }
    }

}
