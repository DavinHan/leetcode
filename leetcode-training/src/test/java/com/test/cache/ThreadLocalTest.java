package com.test.cache;

import java.util.concurrent.*;

public class ThreadLocalTest {

    static ThreadLocal<String> t = new ThreadLocal<>();

    public static void main(String[] args) {
        CountDownLatch count = new CountDownLatch(4);
        new Thread(() -> {
            try {
                Thread.sleep(1);
                t.set("hello");
                System.out.println(t.get());
                count.countDown();
                t.remove();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(2);
                System.out.println(t.get());
                count.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(() -> {
            try {
                Thread.sleep(3);
                t.set("hello");
                System.out.println(t.get());
                count.countDown();
                t.remove();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executor.submit(() -> {
            try {
                Thread.sleep(4);
                System.out.println(t.get());
                count.countDown();
                // 若在线程结束时不清理ThreadLocal，则线程再次利用时，还能拿到
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        try {
            count.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
        System.out.println("exit");
    }
}
