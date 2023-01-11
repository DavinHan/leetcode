package com.test.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NoVolatileVTest {

    private static NoVolatileVTest v;

    private NoVolatileVTest() {}

    /**
     * method getInstance() 中 <pre>v = new NoVolatileVTest()</pre> 字节码如下:
     * <pre>
     * L8
     * LINENUMBER 13 L8
     * NEW com/test/thread/NoVolatileVTest
     * DUP
     * INVOKESPECIAL com/test/thread/NoVolatileVTest.<init> ()V
     * PUTSTATIC com/test/thread/NoVolatileVTest.v : Lcom/test/thread/NoVolatileVTest;
     * </pre>
     * 根据
     */
    public static NoVolatileVTest getInstance() {
        if(v == null) {
            synchronized (NoVolatileVTest.class) {
                if(v == null) {
                    v = new NoVolatileVTest();
                }
            }
        }
        return v;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 1L, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10));
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                System.out.println(NoVolatileVTest.getInstance());
            });
        }
        executor.shutdown();
    }
}