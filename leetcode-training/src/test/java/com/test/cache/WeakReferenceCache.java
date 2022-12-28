package com.test.cache;

import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class WeakReferenceCache {

    @Test
    public void fun1() {
        /*
         * run with VmOptions -Xmx30M -Xms30M
         */
        WeakReference<byte[]> cache = new WeakReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(cache.get());
        byte[] a = new byte[1024 * 1024 * 12];
        System.out.println(cache.get());
    }


    @Test
    public void fun2() {
        /*
         * run with VmOptions -Xmx30M -Xms30M
         */
        WeakReference<Map<String, byte[]>> cache = new WeakReference<>(new HashMap<>());
        cache.get().put("1", new byte[1024 * 1024 * 10]);
        System.out.println(cache.get());
        byte[] a = new byte[1024 * 1024 * 12];
        System.out.println(cache.get());
    }


}
