package com.leetcode.easy;

import java.util.Stack;

/**
 * determines if the string is composed of valid parentheses.
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        String ss = "(){}[]";
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i = 0;i < len;i++) {
            int pos = ss.indexOf(s.charAt(i));
            if(pos % 2 == 0) {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    Character last = stack.pop();
                    if (ss.charAt(pos - 1) != last) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("result >> " + isValid("()") + " , and res is true");
        System.out.println("result >> " + isValid("({") + " , and res is false");
    }
}
