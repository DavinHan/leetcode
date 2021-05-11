package com.leetcode.middle;

public class MyPowXN {

    public static double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return x;
        }
        if (n == 2) {
            return x * x;
        }
        boolean isMin = n == Integer.MIN_VALUE;
        boolean isPositive = n > 0;
        n = n > 0 ? n : -n;
        if(isMin) {
            return myPow(myPow(x, n >> 1), 2) * myPow(x, 2);
        } else {
            if(n % 2 == 0) {
                return isPositive ? myPow(myPow(x, n >> 1), 2) : 1 / myPow(myPow(x , n >> 1), 2);
            } else {
                return isPositive ? myPow(myPow(x, n >> 1), 2) * x : 1 / (myPow(myPow(x , n >> 1), 2) * x);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("target is 0.50000, and test is " + myPow(2.00000, -1));
        System.out.println("target is 1024.00000, and test is " + myPow(2.00000, 10));
        System.out.println("target is 9.26100, and test is " + myPow(2.10000, 3));
        System.out.println("target is 0.25000, and test is " + myPow(2.00000, -2));
    }
}
