package com.leetcode.easy;

/**
 * search the element's position in the array or insert the element and return the position
 */
public class SearchOrInsertInArray {

    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int mid = (left + right) / 2;
        while (left < right && left < right - 1) {
            if(target < nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
            mid = (left + right) / 2;
        }
        if(nums[left] == target) {
            mid = left;
        }
        if(nums[right] == target) {
            mid = right;
        }

        if(nums[mid] == target) {
            return mid;
        } else if (target < nums[left]) {
            return left;
        } else if (target > nums[right]) {
            return right + 1;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        System.out.println("target is 0 and test is " + searchInsert(new int[]{1,3}, 0));
        System.out.println("target is 1 and test is " + searchInsert(new int[]{1,3}, 2));
        System.out.println("target is 3 and test is " + searchInsert(new int[]{1,3,4,6}, 5));
        System.out.println("target is 1 and test is " + searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println("target is 4 and test is " + searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println("target is 0 and test is " + searchInsert(new int[]{1,3,5,6}, 0));
    }
}
