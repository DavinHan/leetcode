package com.test.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author yanhanf
 */
public class TestZZ {

    public static void main(String[] args) throws IOException {
        URL resource = Thread.currentThread().getContextClassLoader().getResource("str.txt");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getPath()));
        String s = br.readLine();
        long s1 = System.currentTimeMillis();
        boolean m1 = Pattern.matches(".*\\(.*\\).*", s);
        long s2 = System.currentTimeMillis();
        System.out.println((s2 - s1) + "ms");
        long s3 = System.currentTimeMillis();
        boolean m2 = Pattern.matches(".+\\(.+\\).+", s);
        long s4 = System.currentTimeMillis();
        System.out.println((s4 - s3) + "ms");
        System.out.println(m1 + ", " + m2);
    }
}
