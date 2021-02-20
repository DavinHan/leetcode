package com.leetcode.middle;

/**
 * find the longest palindrome in the given string
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        String longestSub = "";
        String sub = "";
        int len = s.length();
        for(int i = 0, p = 0, q = 0;i < len;i++) {
            int pos = i;
            for(p = i, q = len - 1;p < q;q--) {
                if(s.charAt(p) == s.charAt(q)) {
                    if (pos == i) {
                        pos = q;
                    }
                    p++;
                } else {
                    if(pos != i) {
                        q = pos;
                        pos = i;
                        p = i;
                    }
                }
            }
            if(p >= q) {
                p++;
            }
            sub = s.substring(i, pos + 1);
            if(sub.length() > longestSub.length()) {
                longestSub = sub;
            }
        }
        return longestSub;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("aacabdkacaa"));
        System.out.println(longestPalindrome("xaabacxcabaaxcabaax"));

    }
}
