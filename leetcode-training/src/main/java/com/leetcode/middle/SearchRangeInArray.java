package com.leetcode.middle;

/**
 * search the range of the target in the given array
 */
public class SearchRangeInArray {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length == 0) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int left = 0, right = nums.length - 1;
        int pos = -1;
        int mid = (left + right) / 2;
        while(left < right && left < right - 1) {
            if(target == nums[mid]) {
                pos = mid;
                break;
            } else if(target < nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
            mid = (left + right) / 2;
        }

        if(target == nums[left]) {
            pos = left;
        }

        if(target == nums[right]) {
            pos = right;
        }

        if(pos == -1) {
            result[0] = -1;
            result[1] = -1;
        } else {
            left = right = pos;
            while(left - 1 >= 0 && nums[left - 1] == target) {
                left--;
            }
            while (right + 1 < nums.length && nums[right + 1] == target) {
                right++;
            }
            result[0] = left;
            result[1] = right;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = null;
        System.out.println("target is [3,4], test is " + (result = searchRange(new int[]{5,7,7,8,8,10}, 8))[0] + "," + result[1]);
        System.out.println("target is [-1,-1], test is " + (result = searchRange(new int[]{5,7,7,8,8,10}, 6))[0] + "," + result[1]);
        System.out.println("target is [3,4], test is " + (result = searchRange(new int[]{}, 0))[0] + "," + result[1]);
        System.out.println("target is [0,1], test is " + (result = searchRange(new int[]{2,2}, 2))[0] + "," + result[1]);
    }
}
