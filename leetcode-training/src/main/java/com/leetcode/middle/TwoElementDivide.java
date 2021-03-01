package com.leetcode.middle;

/**
 * two elements divide, and please don't use multiply or divide
 */
public class TwoElementDivide {

    /**
     * two elements subtract times by times.
     * WARN : Time Limit Exceeded
     */
    public static int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;
        int times = 0;
        boolean isPositive = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        while (divisor >= dividend) {
            dividend = dividend - divisor;
            times++;
        }

        return isPositive ? times : -times;
    }

    public static int divideByBinarySearch(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;
        int times = 0;
        boolean isPositive = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        while (divisor >= dividend) {
            int tmp = divisor;
            int c = 1;
            while(dividend - tmp <= tmp) {
                tmp <<= 1;
                c <<= 1;
            }
            dividend -= tmp;
            times += c;
        }

        return isPositive ? times : -times;
    }

    public static void main(String[] args) {
        System.out.println(divideByBinarySearch(-2147483648, -3));
        System.out.println(divide(-2147483648, -3));
    }
}
