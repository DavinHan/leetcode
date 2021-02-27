package com.leetcode.easy;

import java.util.Arrays;

/**
 * remove the element in the array
 */
public class RemoveTheElementInArray {

    public static int removeElement(int[] nums, int val) {
        int size = nums.length;
        int len = nums.length;
        Arrays.sort(nums);
        int l = len;
        for(int i = 0;i < size;i++) {
            if(nums[i] == val) {
                len--;
                if(l == size) {
                    l = i;
                }
            }
            if(nums[i] > val) {
                for(int j = l;j < size && i < size;j++) {
                    nums[j] = nums[i];
                    i++;
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] n1 = null;
        int len;
        System.out.println((len = removeElement(n1 = new int[]{3,2,2,3}, 3)) + ", " + showArray(n1, len));
        System.out.println((len = removeElement(n1 = new int[]{0,1,2,2,3,0,4,2}, 2)) + ", " + showArray(n1, len));
    }

    public static String showArray(int[] n, int len) {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0;i < len;i++) {
            sb.append(n[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }
}
