package com.agent.demo;

public class HelloWorld {

    public static void main(String[] args) {
//        System.out.println("hello world");
//        mockTimeConsuming();
//        System.out.println("mock time consuming exit");
        int sumNanoTime = 0;
        int sum = 10000;
        for(int i = 0;i < sum;i++) {
            sumNanoTime += mockCPUConsuming1();
        }
        System.out.println( sumNanoTime / 10  + " ns:mock cpu consuming exit");
        int sumMillisTime = 0;
        for (int i = 0; i < sum; i++) {
            sumMillisTime += mockCPUConsuming2();
        }
        System.out.println( sumMillisTime / 10 + " ms:mock cpu consuming exit");

    }

    public static void mockTimeConsuming(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int mockCPUConsuming1(){
        long start = System.nanoTime();
        int result = 0;
        for (int i = 0;i < 1000;i++) {
            result += i;
        }
        long end = System.nanoTime();
        Long c;
        return (c = (end - start)).intValue();
    }

    public static int mockCPUConsuming2(){
        long start = System.currentTimeMillis();
        int result = 0;
        for (int i = 0;i < 1000;i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        Long c;
        return (c = (end - start)).intValue();
    }
}
