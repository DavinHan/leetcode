package com.leetcode.middle;

/**
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k],
 * nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,
 * 2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值
 * target ，则返回 true ，否则返回 false 。
 *
 * @author yanhanf
 */
public class Search {

    public boolean search(int[] nums, int target) {
        if(null == nums || nums.length < 1) {
            return false;
        }
        if(nums.length == 1) {
            return nums[0] == target;
        }
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[start] == nums[end] && nums[mid] == nums[start]) {
                start++;
                end--;
            } else if(nums[mid] >= nums[start]) {
                if(target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[nums.length - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search s = new Search();
        System.out.println("target is true, test is " + s.search(new int[]{2, 1}, 1));
        System.out.println("target is true, test is " + s.search(new int[]{5,1,3}, 3));
        System.out.println("target is true, test is " + s.search(new int[]{0,0,1,1,2,0}, 2));
        System.out.println("target is true, test is " + s.search(new int[]{2,5,6,0,0,1,2}, 0));
        System.out.println("target is false, test is " + s.search(new int[]{2,5,6,0,0,1,2}, 3));
        System.out.println("target is true, test is " + s.search(new int[]{1, 0, 1, 1, 1}, 0));
        System.out.println("target is true, test is " + s.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println("target is true, test is " + s.search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 2));
    }
}
