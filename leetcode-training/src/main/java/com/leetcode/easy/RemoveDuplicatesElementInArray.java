package com.leetcode.easy;

import java.util.Arrays;

/**
 * remove the duplicates element in the array.
 */
public class RemoveDuplicatesElementInArray {

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int size = nums.length;
        int l = len, r = -1;
        for(int i = len - 1;i >= 0;i--) {
            if(i != 0 && nums[i] == nums[i - 1]) {
                nums[i] = Integer.MIN_VALUE;
                len--;
                if(r == -1) {
                    r = i;
                }
                continue;
            }
            l = i + 1;
            if(i != 0 && nums[i] != nums[i - 1] && r != -1) {
                for(int j = r + 1;j < size;j++) {
                    if(nums[j] != Integer.MIN_VALUE) {
                        int tmp = nums[l];
                        nums[l] = nums[j];
                        nums[j] = tmp;
                        l++;
                    }
                }
                r = -1;
            }
            if (i == 0 && r != -1) {
                for(int j = r + 1;j < size;j++) {
                    if(nums[j] != Integer.MIN_VALUE) {
                        int tmp = nums[l];
                        nums[l] = nums[j];
                        nums[j] = tmp;
                        l++;
                    }
                }
                r = -1;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a ;
        System.out.println(removeDuplicates(a = new int[]{1, 1, 2}) + ", " + Arrays.asList(a));
        System.out.println(removeDuplicates(a = new int[]{1, 2, 2, 2, 2, 3, 3, 3}) + ", " + Arrays.asList(a));
        System.out.println(removeDuplicates(a = new int[]{0,0,1,1,1,2,2,3,3,4}) + ", " + Arrays.asList(a));
        System.out.println(0);
    }
}
