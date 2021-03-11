package com.leetcode.middle;

public class SearchTargetInFlipArray {

    public static int search(int[] nums, int target) {
        int pos = -1;
        int left = 0, right = nums.length - 1;
        int mid = (left + right) / 2;
        while(left < right && left < right - 1) {
            if(target == nums[mid]) {
                pos = mid;
                break;
            } else if (target > nums[mid]) {
                if(target == nums[left]) {
                    pos = left;
                    break;
                } else if (target > nums[left]) {
                    left++;
                } else {
                    left = mid;
                }
            } else {
                if (target == nums[left]) {
                    pos = left;
                    break;
                } else if (target > nums[left]) {
                    right = mid;
                } else {
                    left = left + 1;
                }
            }
            mid = (left + right) / 2;
        }
        if(nums[left] == target) {
            pos = left;
        }
        if(nums[right] == target) {
            pos = right;
        }
        return pos;
    }

    public static void main(String[] args) {
        System.out.println("target is 0, result is " + search(new int[]{4}, 4));
        System.out.println("target is 4, result is " + search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println("target is -1, result is " + search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println("target is -1, result is " + search(new int[]{1, 3}, 0));
        System.out.println("target is 1, result is " + search(new int[]{1, 3}, 3));
        System.out.println("target is 1, result is " + search(new int[]{5, 1, 2, 3, 4}, 1));
        System.out.println("target is -1, result is " + search(new int[]{6, 1, 2, 3, 4}, 5));
        System.out.println("target is 0, result is " + search(new int[]{5, 1, 2, 3, 4}, 5));
        System.out.println("target is 0, result is " + search(new int[]{5, 1, 3}, 5));
        System.out.println("target is 2, result is " + search(new int[]{1, 3, 5}, 5));
    }

}
