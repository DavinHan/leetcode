package com.leetcode.difficult;

import java.util.Stack;

/**
 * given n non-negative integers representing the height map of each
 * column with a width of 1, calculate how much rain can be received
 * by the columns arranged in this way after it rains
 */
public class CatchRainTrap {

    public static int trapBySort(int[] height) {
        int sumOfWater = 0;
        for(int i = 1;i < height.length - 1;i++) {
            int left = 0, right = 0;
            // the supreme wall in the left
            for(int j = i - 1;j >= 0;j--) {
                left = Math.max(left, height[j]);
            }

            // the supreme wall in the right
            for(int j = i + 1;j < height.length;j++) {
                right = Math.max(right, height[j]);
            }

            // find the shorter one
            int shorter = Math.min(left, right);
            if (shorter > height[i]) {
                // only calculate current column
                sumOfWater = sumOfWater + (shorter - height[i]);
            }
        }
        return sumOfWater;
    }

    public static int trapByDynamicProgramming(int[] height) {
        int len = height.length;
        int[] rdp = new int[len];
        int[] ldp = new int[len];
        int sumOfWater = 0;
        for(int i = 1;i < len - 1;i++) {
            ldp[i] = Math.max(ldp[i - 1], height[i - 1]);
        }
        for(int i = len - 2;i >= 0;i--) {
            rdp[i] = Math.max(rdp[i + 1], height[i + 1]);
        }
        for(int i = 1;i < len - 1;i++) {
            int min = Math.min(ldp[i], rdp[i]);
            if(min > height[i]) {
                sumOfWater += min - height[i];
            }
        }
        return sumOfWater;
    }

    public static int trapByStack(int[] height) {
        int len = height.length;
        Stack<Integer> stack = new Stack<>();
        int sumOfWater = 0;
        stack.push(0);
        for (int i = 1;i < len;i++) {
            if(height[i] < height[stack.peek()]) {
                stack.push(i);
            } else if(height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();
                    if(!stack.isEmpty()) {
                        int waterH = Math.min(height[i], height[stack.peek()]) - height[mid];
                        int waterW = i - stack.peek() - 1;
                        sumOfWater += waterH * waterW;
                    }
                }
                stack.push(i);
            }
        }
        return sumOfWater;
    }

    public static void main(String[] args) {
        System.out.println("target is 6, test is " + trapBySort(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println("target is 9, test is " + trapBySort(new int[]{4,2,0,3,2,5}));
        System.out.println("target is 6, test is " + trapByDynamicProgramming(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println("target is 9, test is " + trapByDynamicProgramming(new int[]{4,2,0,3,2,5}));
        System.out.println("target is 6, test is " + trapByStack(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println("target is 9, test is " + trapByStack(new int[]{4,2,0,3,2,5}));
    }
}
