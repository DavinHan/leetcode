package com.leetcode.common;

public class ArrayUtil {

    public static String showArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i : arr) {
            sb.append(i).append(",");
        }
        String s = sb.substring(0, sb.length() - 1);
        return (s + "]");
    }
}
