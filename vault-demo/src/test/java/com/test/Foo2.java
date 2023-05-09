package com.test;

public class Foo2 {
    public static void main(String[] args) throws ClassNotFoundException {
        // Will execute after Baz is initialized.
        Thread.currentThread().getContextClassLoader().loadClass("com.test.Bar2");
        System.out.println("a");
        Class.forName("com.test.Bar2");
    }
}
