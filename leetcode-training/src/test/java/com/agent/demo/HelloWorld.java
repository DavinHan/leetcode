package com.agent.demo;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("hello world");
        mockTimeConsuming();
        System.out.println("mock time consuming exit");
        System.out.println(mockCPUConsuming() + " :mock cpu consuming exit");

    }

    public static void mockTimeConsuming(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int mockCPUConsuming(){
        int result = 0;
        for (int i = 0;i < 1000;i++) {
            result += i;
        }
        return result;
    }
}
