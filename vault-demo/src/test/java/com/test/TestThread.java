package com.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TestThread {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestThread.class);

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

    @Test
    public void fun2() throws ExecutionException, InterruptedException {
        ThreadLocal<String> t = new ThreadLocal<>();
        t.set("hello");
        CompletableFuture<Object> ok = CompletableFuture.supplyAsync(() -> {
            LOGGER.error(t.get());
            t.set("chen");
            LOGGER.error(t.get());
            Arrays.stream(Thread.currentThread().getStackTrace()).forEach(e -> LOGGER.error(e.toString()));
            LOGGER.error("1:" + Thread.currentThread().getId());
            LOGGER.error("---------------------------------------");
            return "ok";
        }).thenApply((fn) -> {
            LOGGER.error("==========================================");
            LOGGER.error(fn);
            LOGGER.error(t.get());
            Arrays.stream(Thread.currentThread().getStackTrace()).forEach(e -> LOGGER.error(e.toString()));
            LOGGER.error("2:" + Thread.currentThread().getId());
            t.set("ai");
            LOGGER.error(t.get());
            return "jok";
        });
        LOGGER.error("主" + t.get());
        LOGGER.error(ok.get().toString());
    }

    public void stackFun() {

    }
}
