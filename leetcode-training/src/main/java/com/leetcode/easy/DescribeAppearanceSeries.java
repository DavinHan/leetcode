package com.leetcode.easy;

/**
 * describe the appearance series
 */
public class DescribeAppearanceSeries {

    public static String countAndSay(int n) {
        String result = "1";
        for(int i = 2;i <= n;i++) {
            String tmp = "";
            for(int j = 0;j < result.length();) {
                int count = 1;
                for(int k = j + 1;k < result.length();k++) {
                    if(result.charAt(k) == result.charAt(k - 1)) {
                        count++;
                    } else {
                        break;
                    }
                }
                tmp = tmp + count + result.charAt(j);
                j += count;
            }
            result = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(30));
    }
}
