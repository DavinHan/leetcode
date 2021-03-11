package com.leetcode.difficult;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        int len = s.length();
        int sum = 0;
        int left = 0, right = 0;
        for (int i = 0;i < len;i++) {
            if(s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if(left == right) {
                sum = Math.max(sum, right * 2);
            } else if(left < right) {
                left = 0;
                right = 0;
            }
        }
        left = right = 0;
        for (int i = len - 1;i >= 0;i--) {
            if(s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if(left == right) {
                sum = Math.max(sum, right * 2);
            } else if(left > right) {
                left = 0;
                right = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("expect is 2, test is " + longestValidParentheses("(()"));
        System.out.println("expect is 4, test is " + longestValidParentheses(")()())"));
        System.out.println("expect is 2, test is " + longestValidParentheses("()(()"));
        System.out.println("expect is 0, test is " + longestValidParentheses(""));
    }
}
