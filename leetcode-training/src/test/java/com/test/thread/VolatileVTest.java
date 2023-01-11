package com.test.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class VolatileVTest {

    private static volatile VolatileVTest v;

    private VolatileVTest(){}

    /**
     * method getInstance() 中 <pre>v = new VolatileVTest()</pre> 字节码如下:
     * <pre>
     * L8
     * LINENUMBER 13 L8
     * NEW com/test/thread/VolatileVTest
     * DUP
     * INVOKESPECIAL com/test/thread/VolatileVTest.<init> ()V
     * PUTSTATIC com/test/thread/VolatileVTest.v : Lcom/test/thread/VolatileVTest;
     * </pre>
     */
    public static VolatileVTest getInstance() {
        if(v == null) {
            synchronized (VolatileVTest.class) {
                if(v == null) {
                    v = new VolatileVTest();
                }
            }
        }
        return v;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 1L, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10));
        for (int i = 0;i < 5;i++) {
            executor.submit(() -> {
                System.out.println(VolatileVTest.getInstance());
            });
        }
        executor.shutdown();
    }
}
