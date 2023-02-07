package com.test.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestUtil {
    private static final Map<String, Set<String>> map = new HashMap();

    public TestUtil() {
    }

    public static Map<String, Set<String>> getMap() {
        return map;
    }

    static {
        Set<String> s = new HashSet<>();
        s.add("asd");
        Set<String> s2 = new HashSet<>();
        s2.add("asd");

        map.put("com.test.ApplicationStarter", s);
        map.put("com.test.ApplicationStarter2", s2);
    }
}