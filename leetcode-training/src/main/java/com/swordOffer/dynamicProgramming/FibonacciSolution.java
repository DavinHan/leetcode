package com.swordOffer.dynamicProgramming;

public class FibonacciSolution {

    public static long fibonacciInRecursion(int i){
        if(i == 1 || i == 2) {
            return 1;
        } else {
            return fibonacciInRecursion(i - 1) + fibonacciInRecursion(i - 2);
        }
    }

    public static long fibonacciInDynamicProgramming(int i) {
        long[] arr = new long[i];
        for(int ii = 0;ii < i;ii++) {
            if(ii == 0 || ii == 1) {
                arr[ii] = 1;
            } else {
                arr[ii] = arr[ii - 1] + arr[ii - 2];
            }
        }
        return arr[i - 1];
    }

    public static void main(String[] args) {
        long s1 = System.currentTimeMillis();
        System.out.println(fibonacciInRecursion(50));
        long s2 = System.currentTimeMillis();
        System.out.println(fibonacciInDynamicProgramming(50));
        long s3 = System.currentTimeMillis();
        System.out.println("recursion cost : " + (s2 - s1) + ", dynamic programming cost : " + (s3 - s2));
        /**
         * 12586269025
         * 12586269025
         * recursion cost : 28249, dynamic programming cost : 0
         */
    }
}
