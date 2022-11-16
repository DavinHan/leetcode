package com.test.web;

import com.test.selector.MySelector;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 请求测试
 *
 * @author yanhanf
 */
@RestController
public class HealthWeb {

    private final static DelayQueue<MySelector> selectors = new DelayQueue<>();

    private final static String DEFAULT_NAME = "mySelector-";
    private final static AtomicInteger i = new AtomicInteger(0);

    @GetMapping("/health")
    public String health(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        String key;
        while(headerNames.hasMoreElements()) {
            map.put((key = headerNames.nextElement()), request.getHeader(key));
        }
        return "ok,headers is :" + map.toString();
    }

    @GetMapping("/put")
    public String put(String tag) {
        selectors.removeIf(s -> tag.equals(s.getTag()));
        return selectors.toString();
    }

    @GetMapping("/addSelector")
    public String addSelector(String tag) {
        MySelector s = new MySelector(tag, DEFAULT_NAME + i.getAndIncrement(), 30, TimeUnit.SECONDS);
        selectors.put(s);
        return selectors.toString();
    }

    @Scheduled(fixedDelay = 1000L)
    public void clear() {
        selectors.removeIf(s -> s.getDelay(TimeUnit.SECONDS) < 0);
        System.out.println("当前selectors队列为>>>>" + selectors);
    }
}
