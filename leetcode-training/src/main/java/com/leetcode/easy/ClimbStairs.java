package com.leetcode.easy;

/**
 *
 * @author yanhanf
 * @Description TODO
 * @ClassName ClimbStairs
 * @Date 2021/11/27
 */
public class ClimbStairs {

    /**
     * 时间复杂度：O(n*n)
     * 空间复杂度：O(n*n)
     */
    public static int climbStairs1(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static int climbStairs2(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[0] = arr[1] = 1;
        for(int i = 2;i <= n;i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int climbStairs(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        int result = 0, a = 1, b = 1;
        for(int i = 2;i <= n;i++) {
            result = a + b;
            b = a;
            a = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs2(2) + "," + climbStairs(2));
        System.out.println(climbStairs2(5) + "," + climbStairs(5));
        System.out.println(climbStairs2(10) + "," + climbStairs(10));
        System.out.println(climbStairs2(45) + "," + climbStairs(45));
    }
}
