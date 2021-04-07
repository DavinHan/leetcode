package com.leetcode.middle;

public class JumpWithLeastTimes {

    /**
     * Greedy Algorithm
     */
    public static int jump(int[] nums) {
        int len = nums.length - 1;
        int end = 0;
        int paths = 0;
        int maxPosition = 0;
        for(int i = 0;i < len;i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if(i == end) {
                end = maxPosition;
                paths++;
            }
        }
        return paths;
    }

    public static void main(String[] args) {
        System.out.println("target is 3, and test is " + jump(new int[]{2,1,1,1,1}));
        System.out.println("target is 0, and test is " + jump(new int[]{1}));
        System.out.println("target is 2, and test is " + jump(new int[]{2,3,1,1,4}));
        System.out.println("target is 2, and test is " + jump(new int[]{2,3,0,1,4}));
        System.out.println("target is 0, and test is " + jump(new int[]{0}));
    }
}
