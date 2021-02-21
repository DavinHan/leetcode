package com.leetcode.easy;

/**
 * find the longest public prefix in all the strings.
 */
public class LongestPublicPrefix {

    public static String longestCommonPrefix(String[] strings) {
        if(strings == null || strings.length == 0) {
            return "";
        }
        String result = strings[0];
        int len = strings.length;
        for(int i = 0;i < len;i++) {
            if(result.equals(strings[i])) {
                continue;
            } else {
                int min = Math.min(result.length(), strings[i].length());
                while (result.length() > min) {
                    result = result.substring(0, result.length() - 1);
                }
                while (strings[i].length() > min) {
                    strings[i] = strings[i].substring(0, strings[i].length() - 1);
                }
                while (!result.equals(strings[i])) {
                    result = result.substring(0, result.length() - 1);
                    strings[i] = strings[i].substring(0, strings[i].length() - 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}) + ",");
    }
}
