package com.test;

public abstract class Bar2 {

    static {
        System.out.println("bar");
        // Will execute before Baz is initialized!
    }
}