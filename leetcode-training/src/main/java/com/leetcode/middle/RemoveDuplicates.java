package com.leetcode.middle;

import com.leetcode.common.ArrayUtil;

import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @author yanhanf
 */
public class RemoveDuplicates {

    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if(n < 3) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if(nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) {
            return nums.length;
        }
        int p = 1, pp = 0, sum = 1;
        while(p < nums.length) {
            if(nums[p] == nums[pp] && p - pp > 1) {
                nums[p] = Integer.MAX_VALUE;
            } else {
                sum++;
                if(nums[p] != nums[pp]) {
                    pp = p;
                }
            }
            p++;
        }

        Arrays.sort(nums);
        return sum;
    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        int[] a1 = new int[]{1,1,1,2,2,3};
        int n;
        System.out.println("target is 5, [1,1,2,2,3], and test is "
                + (n = rd.removeDuplicates2(a1)) + ", " + ArrayUtil.showArray(a1, n));
        a1 = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println("target is 7, [0,0,1,1,2,3,3], and test is "
                + (n = rd.removeDuplicates2(a1)) + ", " + ArrayUtil.showArray(a1, n));

    }
}
