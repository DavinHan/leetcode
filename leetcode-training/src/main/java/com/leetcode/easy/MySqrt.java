package com.leetcode.easy;

/**
 * @author yanhanf
 * @Description TODO
 * @ClassName MySqrt
 * @Date 2021/11/26
 */
public class MySqrt {

    public static int mySqrt(int x) {
        for(int i = 1;i <= x;i++) {
            int tmp = i * i;
            if(tmp == x){
                return i;
            } else if(tmp > x || tmp < 0) {
                return i - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("期望结果:46340,test is " + mySqrt(2147395600));
        System.out.println("期望结果:46340,test is " + mySqrt(2147483647));
    }
}
