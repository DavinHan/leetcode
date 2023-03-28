package com.test;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
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
