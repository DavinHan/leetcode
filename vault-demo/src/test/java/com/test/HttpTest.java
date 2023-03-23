package com.test;

import org.junit.jupiter.api.Test;
/**
 * TODO
 *
 * @author yanhanf
 */
public class HttpTest {

    @Test
    public void test2() {
        test22();
        System.gc();
        System.out.println("exit");
    }

    public void test22() {
        new TestDestroy();
    }
}
