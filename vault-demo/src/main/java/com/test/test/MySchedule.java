package com.test.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MySchedule {

    private final AtomicInteger i = new AtomicInteger(0);
    private final ThreadFactory namedThreadFactory = r -> new Thread(r, "pool-%d");
    private final ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(2, namedThreadFactory);
    private static final Logger LOGGER = LoggerFactory.getLogger(MySchedule.class);

    @PostConstruct
    public void init() {
        pool.schedule(this::schedule, 30, TimeUnit.SECONDS);
    }

    public void schedule() {
        try {
            LOGGER.error("=========={}", i.getAndIncrement());
        } finally {
            pool.schedule(this::schedule, 30, TimeUnit.SECONDS);
        }
    }
}
