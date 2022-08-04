package com.leetcode.easy;

import com.leetcode.common.ArrayUtil;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并
 * 的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * @author yanhanf
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length;
        // 从大到小，复用nums1
        int i = len - 1, p = m - 1, q = n - 1;
        while (i >= 0 && p >= 0 && q >= 0) {
            if(nums1[p] > nums2[q]) {
                nums1[i] = nums1[p];
                p--;
            } else {
                nums1[i] = nums2[q];
                q--;
            }
            i--;
        }
        if(q >= 0) {
            for(; i >= 0 && q >= 0;i--, q--) {
                nums1[i] = nums2[q];
            }
        }
    }

    public static void main(String[] args) {
        Merge m = new Merge();
        int[] n1 = new int[]{1,2,3,0,0,0};
        int[] n2 = new int[]{2,5,6};
        m.merge(n1, 3, n2, n2.length);
        System.out.println("target is [1,2,2,3,5,6], and test is " + ArrayUtil.showArray(n1));
        n1 = new int[]{1};
        n2 = new int[]{};
        m.merge(n1, 1, n2, n2.length);
        System.out.println("target is [1], and test is " + ArrayUtil.showArray(n1));
        n1 = new int[]{0};
        n2 = new int[]{1};
        m.merge(n1, 0, n2, n2.length);
        System.out.println("target is [1], and test is " + ArrayUtil.showArray(n1));
    }
}
