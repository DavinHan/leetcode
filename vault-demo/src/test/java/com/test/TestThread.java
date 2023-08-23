package com.test;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TestThread {

    @Test
    public void fun() throws InterruptedException {
        Map<Character, CopyOnWriteArraySet<Character>> ROUTE_CLIENTS = new ConcurrentHashMap<>();
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() * 2);
        // 频繁写入
        pool.submit(() -> {
            while (true) {
                char[] ch = UUID.randomUUID().toString().toCharArray();
                if (ROUTE_CLIENTS.containsKey(ch[0])) {
                    CopyOnWriteArraySet<Character> chs = ROUTE_CLIENTS.get(ch[0]);
                    chs.add(ch[1]);
                } else {
                    CopyOnWriteArraySet<Character> chs = new CopyOnWriteArraySet<>();
                    chs.add(ch[1]);
                    ROUTE_CLIENTS.put(ch[0], chs);
                }
            }
        });
        // 频繁写入
        pool.submit(() -> {
            while (true) {
                char[] ch = UUID.randomUUID().toString().toCharArray();
                if (ROUTE_CLIENTS.containsKey(ch[0])) {
                    CopyOnWriteArraySet<Character> chs = ROUTE_CLIENTS.get(ch[0]);
                    chs.add(ch[1]);
                } else {
                    CopyOnWriteArraySet<Character> chs = new CopyOnWriteArraySet<>();
                    chs.add(ch[1]);
                    ROUTE_CLIENTS.put(ch[0], chs);
                }
            }
        });

        // 频繁读取
        final AtomicInteger i = new AtomicInteger(0);
        pool.submit(() -> {
            while (true) {
                char[] ch = UUID.randomUUID().toString().toCharArray();
                CopyOnWriteArraySet<Character> chs = ROUTE_CLIENTS.get(ch[0]);
                if (chs == null) {
                    System.out.println("NULL11");
                }
                i.getAndIncrement();
                if (i.get() % 9999999 == 0) {
                    System.out.println("i" + chs);
                }
            }
        });

        final AtomicInteger j = new AtomicInteger(0);
        final AtomicReference<Character> ct = new AtomicReference<>();
        pool.submit(() -> {
            while (true) {
                char[] ch = UUID.randomUUID().toString().toCharArray();
                CopyOnWriteArraySet<Character> chs = ROUTE_CLIENTS.get(ch[0]);
                if (chs == null) {
                    System.out.println("NULL22");
                }
                j.getAndIncrement();
                if (j.get() % 9999999 == 0) {
                    System.out.println("j" + chs);
                }
            }
        });


        Thread.sleep(1000000L);
    }

    @Test
    public void fun1() {
        System.out.println(UUID.randomUUID());
    }
}
