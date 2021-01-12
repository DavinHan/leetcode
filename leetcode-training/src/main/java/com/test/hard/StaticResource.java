package com.test.hard;

public class StaticResource {

    static abstract class Human{

    }

    static class Man extends Human{

    }

    static class Woman extends Human{

    }

    public void hello(Human h) {
        System.out.println("human - " + h);
    }

    public void hello(Man m) {
        System.out.println("man - " + m);
    }

    public void hello(Woman w) {
        System.out.println("woman - " + w);
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticResource s = new StaticResource();
        s.hello((Woman) woman);
        s.hello((Man) man);
    }
}