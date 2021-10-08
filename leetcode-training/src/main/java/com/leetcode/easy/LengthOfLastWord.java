package com.leetcode.easy;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        String[] ss = s.split(" ");
        if(ss.length == 0) {
            return 0;
        } else {
            return ss[ss.length - 1].length();
        }
    }

    public static int lengthOfLastWord2(String s) {
        int len = 0;
        if(s == null || "".equals(s)) {
            return len;
        }
        for(int i = s.length() - 1;i >= 0;i--) {
            if(s.charAt(i) == ' ') {
                if(len != 0) {
                    break;
                }
            } else {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println("target is 5, and test is " + lengthOfLastWord2("Hello World"));
        System.out.println("target is 0, and test is " + lengthOfLastWord2(" "));
        System.out.println("target is 0, and test is " + lengthOfLastWord2("   "));
    }
}
