package com.test.selector;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author yanhanf
 */
public class MySelector implements Delayed {

    private final long ttl;
    private final String name;

    private final String tag;

    public MySelector(String tag, String name, long ttl, TimeUnit unit) {
        this.tag = tag;
        this.name = name;
        this.ttl = System.currentTimeMillis() + (ttl > 0 ? unit.toMillis(ttl) : 0);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return ttl - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        MySelector s = (MySelector) o;
        return (this.ttl - s.ttl) > 0 ? 1 : -1;
    }

    public String getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return "MySelector{" +
                "ttl=" + ttl +
                ", name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
