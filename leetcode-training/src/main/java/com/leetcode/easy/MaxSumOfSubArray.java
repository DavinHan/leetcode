package com.leetcode.easy;

public class MaxSumOfSubArray {

    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length < 1) {
            return -1;
        }
        int maxSA = nums[0];
        int len = nums.length;
        for (int i = 0;i < len;i++) {
            int tmp = 0;
            for (int j = i;j < len;j++) {
                tmp += nums[j];
                if(tmp > maxSA) {
                    maxSA = tmp;
                }
            }
        }
        return maxSA;
    }

    public static void main(String[] args) {
        System.out.println("target is 6, and test result is " + maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println("target is 1, and test result is " + maxSubArray(new int[]{1}));
        System.out.println("target is 0, and test result is " + maxSubArray(new int[]{0}));
        System.out.println("target is -1, and test result is " + maxSubArray(new int[]{-1}));
    }
}
