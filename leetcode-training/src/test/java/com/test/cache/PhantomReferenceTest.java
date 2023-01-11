package com.test.cache;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {

    public static void main(String[] args) {
        ReferenceQueue<String> q = new ReferenceQueue<>();
        PhantomReference<String> pr = new PhantomReference<>("hello", q);
        pr.enqueue();
        System.out.println(pr);
//        try {
//            System.gc();
//            Thread.sleep(0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(pr);
//
//        try {
//            System.gc();
//            Thread.sleep(0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        q.poll();
        System.out.println(pr);
    }
}
