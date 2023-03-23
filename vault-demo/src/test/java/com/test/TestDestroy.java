package com.test;

public class TestDestroy {


    @Override
    protected void finalize() throws Throwable {
        System.out.println("die");
    }
}
