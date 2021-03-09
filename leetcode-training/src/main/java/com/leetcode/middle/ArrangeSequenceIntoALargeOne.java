package com.leetcode.middle;

import java.util.Arrays;

/**
 * to arrange a given sequence into a larger sequence within a dictionary sequence.
 * find next larger integer(sequence).
 */
public class ArrangeSequenceIntoALargeOne {

    public static void nextPermutation(int[] nums) {
        int min = 0, minPos = -1;
        int maxPos = -1;
        for(int i = nums.length - 1;i > 0;i--) {
            if(nums[i - 1] < nums[i]) {
                min = nums[i - 1];
                minPos = i - 1;
                break;
            }
        }

        if(minPos == -1) {
            Arrays.sort(nums);
        } else {
            for (int i = minPos + 1;i < nums.length;i++) {
                if(nums[i] > min) {
                    maxPos = i;
                }
            }
            if (maxPos == -1) {
                Arrays.sort(nums);
            } else {
                int tmp = nums[minPos];
                nums[minPos] = nums[maxPos];
                nums[maxPos] = tmp;

                // 从minPos往后有小到大排序
                for(int i = minPos + 1;i < nums.length;i++) {
                    for(int j = minPos + 2;j < nums.length;j++) {
                        if(nums[j - 1] > nums[j]) {
                            tmp = nums[j - 1];
                            nums[j - 1] = nums[j];
                            nums[j] = tmp;
                        }
                    }
                }
            }
        }
    }

    // 查找下一次最大排序的子序列
    public static void main(String[] args) {
        int[] a1 = new int[]{1, 2, 3};// 1,3,2
        nextPermutation(a1);
        int[] a2 = new int[]{1}; // 1
        nextPermutation(a2);
        int[] a3 = new int[]{3, 2, 1}; // 1,2,3
        nextPermutation(a3);
        int[] a4 = new int[]{1, 1, 5}; // 1,5,1
        nextPermutation(a4);
        int[] a5 = new int[]{1, 1, 5, 2, 3}; // 1,5,1,2,3
        nextPermutation(a5);
        int[] a6 = new int[]{1, 2}; // 2,1
        nextPermutation(a6);
        int[] a7 = new int[]{1, 3, 2}; // 2,1,3
        nextPermutation(a7);
        int[] a8 = new int[]{5, 4, 7, 5, 3, 2}; // 5,5,2,3,4,7
        nextPermutation(a8);

        //5,5,7,4,3,2
        //5,5,2,3,4,7
    }
}
