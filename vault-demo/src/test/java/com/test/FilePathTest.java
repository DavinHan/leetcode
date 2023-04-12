package com.test;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FilePathTest {

    @Test
    public void test1() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.writeLock().lock();
        lock.writeLock().unlock();

        lock.readLock().lock();
        lock.readLock().unlock();
    }

    @Test
    public void test2() {
        Map<String, Map<String, List<String>>> a = new HashMap<>();
        List<String> c = new ArrayList<>();
        c.add("lkaj");
        c.add("zcsa");
        Map<String, List<String>> b = new HashMap<>();
        b.put("qwa", c);
        a.put("ppp", b);

        Gson gson = new Gson();

        String s = gson.toJson(a);

        HashMap map = gson.fromJson(s, HashMap.class);
        Map map1 = (Map) map.get("ppp");
        System.out.println(map1.get("qwa"));
    }

    @Test
    public void test() throws URISyntaxException {
        URL url = FilePathTest.class.getClassLoader().getResource(".");
        if(url == null) {
            System.out.println("null");
            return;
        }
        File file = new File(url.getPath());
        Path path = file.toPath();
        System.out.println(path);
        Path path1 = Paths.get("src", "main", "resources").toAbsolutePath();
        System.out.println(path1);
    }
}
