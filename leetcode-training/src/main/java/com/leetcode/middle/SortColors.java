package com.leetcode.middle;

import com.leetcode.common.ArrayUtil;

/**
 * 颜色分类
 * @author yanhanf
 * @Description 颜色分类
 * @ClassName SortColors
 * @Date 2021/12/7
 */
public class SortColors {

    /**
     * 快速排序
     * 因为 只有 0,1,2，只需0 在左，2在右即可
     */
    public static void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                default:
                    break;
            }
        }
        int i = 0;
        while(i < count0) {
            nums[i++] = 0;
        }
        while(i < count0 + count1) {
            nums[i++] = 1;
        }
        while(i < count0 + count1 + count2) {
            nums[i++] = 2;
        }
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{2,0,2,1,1,0};
        sortColors(n1);
        System.out.println("target is [0,0,1,1,2,2],test is " + ArrayUtil.showArray(n1));

        int[] n2 = new int[]{2,0,1};
        sortColors(n2);
        System.out.println("target is [0,1,2],test is " + ArrayUtil.showArray(n2));

        int[] n3 = new int[]{0};
        sortColors(n3);
        System.out.println("target is [0],test is " + ArrayUtil.showArray(n3));

        int[] n4 = new int[]{1};
        sortColors(n4);
        System.out.println("target is [1],test is " + ArrayUtil.showArray(n4));
    }
}
