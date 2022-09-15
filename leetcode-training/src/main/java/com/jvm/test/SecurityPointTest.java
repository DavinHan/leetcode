package com.jvm.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 安全点测试
 *
 * @author yanhanf
 */
public class SecurityPointTest {

    /**
     * 测试结果: <br/>
     * 99999999 <br/>
     * 99999999 <br/>
     * 主线程1停止
     */
    public static void test1() {
        int sum = 999999999;
        Thread a = new Thread(() -> {
            AtomicInteger a1 = new AtomicInteger(0);
            for (int i = 0; i < sum; i++) {
                a1.getAndIncrement();
            }
            System.out.println(a1);
        });
        Thread b = new Thread(() -> {
            AtomicInteger b1 = new AtomicInteger(0);
            for (int i = 0; i < sum; i++) {
                b1.getAndIncrement();
            }
            System.out.println(b1);
        });
        a.start();
        b.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("主线程1停止");
    }


    /**
     * 测试结果: <br/>
     * 主线程2停止 <br/>
     * 99999999 <br/>
     * 99999999
     */
    public static void test2() {
        int sum = 999999999;
        Thread a = new Thread(() -> {
            AtomicInteger a1 = new AtomicInteger(0);
            for (long i = 0; i < sum; i++) {
                a1.getAndIncrement();
            }
            System.out.println(a1);
        });
        Thread b = new Thread(() -> {
            AtomicInteger b1 = new AtomicInteger(0);
            for (long i = 0; i < sum; i++) {
                b1.getAndIncrement();
            }
            System.out.println(b1);
        });
        a.start();
        b.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("主线程2停止");
    }

    /**
     * 测试结果: <br/>
     * 主线程3停止 <br/>
     * 99999999 <br/>
     * 99999999
     */
    public static void test3() {
        int sum = 999999999;
        Thread a = new Thread(() -> {
            AtomicInteger a1 = new AtomicInteger(0);
            for (int i = 0; i < sum; i++) {
                a1.getAndIncrement();
                if(i % 1000 == 0) {
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println(a1);
        });
        Thread b = new Thread(() -> {
            AtomicInteger b1 = new AtomicInteger(0);
            for (int i = 0; i < sum; i++) {
                b1.getAndIncrement();
                if(i % 1000 == 0) {
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println(b1);
        });
        a.start();
        b.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("主线程3停止");
    }

    /**
     * 99999999
     * 99999999
     * 主线程1停止
     * 主线程2停止
     * 主线程3停止
     * 99999999
     * 99999999
     * 99999999
     * 99999999
     */
    public static void main(String[] args) {
        test1();
//        test2();
//        test3();
    }
}
