package com.leetcode.middle;

import java.util.Arrays;

/**
 * find the sum of three integer which is near the target.
 */
public class FindSumOfThreeNearTarget {

    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            return  0;
        }
        int result = 0;
        int len = nums.length;
        Arrays.sort(nums);
        int near = Integer.MAX_VALUE;
        int l, r;
        for(int i = 0;i < len;i++) {
            l = i + 1;
            r = len - 1;
            while(l < r) {
                int n = Math.abs(nums[i] + nums[l] + nums[r] - target);
                if(near > n) {
                    near = n;
                    result = nums[i] + nums[l] + nums[r];
                }
                if(nums[i] + nums[l] + nums[r] > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("target 2, result > " + threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println("target 82, result > " + threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82));
    }
}
