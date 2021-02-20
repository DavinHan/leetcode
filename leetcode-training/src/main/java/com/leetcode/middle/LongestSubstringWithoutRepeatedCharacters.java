package com.leetcode.middle;

/**
 * find the longest substring without repeated characters.
 */
public class LongestSubstringWithoutRepeatedCharacters {

    public static int lengthOfLongestSubstring(String s) {
        String longestSub = "";
        String sub = "";
        int p = 0;
        int len = s.length();
        for(int i = 0;i < len;i++) {
            sub = "";
            for(p = i;p < len;p++) {
                if(sub.indexOf(s.charAt(p)) > -1) {
                    break;
                } else {
                    sub += s.charAt(p);
                }
            }
            if(longestSub.length() < sub.length()) {
                longestSub = sub;
            }
        }
        return longestSub.length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
    }
}
