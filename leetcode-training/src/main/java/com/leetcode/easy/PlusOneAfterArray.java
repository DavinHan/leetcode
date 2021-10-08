package com.leetcode.easy;

import com.leetcode.common.ArrayUtil;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 */
public class PlusOneAfterArray {

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int add = 1;
        for(int i = len - 1;i >= 0;i--) {
            if(digits[i] + add > 9) {
                digits[i] = (digits[i] + add) % 10;
                add = 1;
            } else {
                digits[i] = (digits[i] + add);
                add = 0;
            }
        }
        if(add == 1) {
            int[] newDigits = new int[len + 1];
            System.arraycopy(digits, 0, newDigits, 1, len);
            newDigits[0] = 1;
            return newDigits;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        System.out.println(ArrayUtil.showArray(plusOne(new int[]{1,2,3})));
        System.out.println(ArrayUtil.showArray(plusOne(new int[]{9})));
    }
}
