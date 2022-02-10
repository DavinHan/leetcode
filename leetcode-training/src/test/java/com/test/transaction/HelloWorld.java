package com.test.transaction;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

public class HelloWorld {

    private static String outStr = "hello";

    @Test
    public void testHello(){
        try {
            bFun();
        } catch (Exception ignored) {
        }
        System.out.println(outStr);
    }

    @Transactional
    public void aFun(){
        outStr += "a";
        System.out.println(outStr);
    }

    @Transactional()
    public void bFun(){
        outStr += "b";
        System.out.println(outStr);
        aFun();
        throw new RuntimeException("aa");
    }

    @Test
    public void testIf(){
        int a = 0;
        if(a == 0) {
            a++;
        } else if (a == 1) {
            a++;
        } else if (a == 2) {
            a++;
        } else {
            a++;
        }
        System.out.println(a);
    }
}
