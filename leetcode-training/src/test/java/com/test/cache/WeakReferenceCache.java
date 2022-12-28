package com.test.cache;

import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class WeakReferenceCache {

    @Test
    public void fun1() {
        WeakReference<byte[]> cache = new WeakReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(cache.get());
        System.gc();
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        byte[] a = new byte[1024 * 1024 * 12];
        System.out.println(cache.get());
    }


    @Test
    public void fun2() {
        WeakReference<Map<String, byte[]>> cache = new WeakReference<>(new HashMap<>());
        cache.get().put("1", new byte[1024 * 1024 * 10]);
        System.out.println(cache.get());
        System.gc();
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        byte[] a = new byte[1024 * 1024 * 12];
        System.out.println(cache.get());
    }


}
