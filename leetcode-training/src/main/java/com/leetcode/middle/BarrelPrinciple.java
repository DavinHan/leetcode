package com.leetcode.middle;

/**
 * find the max area to put the most water
 */
public class BarrelPrinciple {

    public static int maxArea(int[] height) {
        if(height == null || height.length < 2) {
            return 0;
        }
        int maxArea = 0;
        int len = height.length;
        for(int i = 0;i < len;i++) {
            for(int j = i + 1;j < len;j++) {
                int min = Math.min(height[i], height[j]);
                int area = min * (j - i);
                if(area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 1}));
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{4, 3, 2, 1, 4}));
        System.out.println(maxArea(new int[]{1, 2, 1}));
    }
}
