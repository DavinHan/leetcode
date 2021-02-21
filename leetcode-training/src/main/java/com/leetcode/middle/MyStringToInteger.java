package com.leetcode.middle;

/**
 * String to integer.
 */
public class MyStringToInteger {

    public static int myAtoi(String s) {
        if(s == null || "".equals(s)) {
            return 0;
        }
        s = s.trim();
        if(s == null || "".equals(s)) {
            return 0;
        }
        StringBuilder integer = new StringBuilder();
        if(((int)s.charAt(0) < 48 || (int)s.charAt(0) > 57) && s.charAt(0) != '-' && s.charAt(0) != '+') {
            return 0;
        }
        boolean isStop = false;
        boolean isNegative = false;
        for(int i = 0;i < s.length();i++) {
            if((s.charAt(i) >= 48 && s.charAt(i) <= 57)
                    || s.charAt(i) == '-'
                    || s.charAt(i) == '.'
                    || s.charAt(i) == '+') {
                if(s.charAt(i) == '.') {
                    isStop = true;
                    continue;
                }
                if(s.charAt(i) == '+') {
                    if(i == 0) {
                        isNegative = false;
                    } else {
                        isStop = true;
                    }
                    continue;
                }
                if(s.charAt(i) == '-') {
                    if(i == 0) {
                        isNegative = true;
                    } else {
                        isStop = true;
                    }
                    continue;
                }
                if (!isStop) {
                    integer.append(s.charAt(i));
                }
            } else {
                break;
            }
        }
        int[] integers = new int[integer.length()];
        for (int i = 0;i < integer.length();i++) {
            integers[i] = (int) integer.charAt(i) - 48;
        }

        int radix = 10;
        int result = 0;
        int max = Integer.MAX_VALUE / 10;

        for(int i = 0;i < integers.length;i++) {
            if(result <= max) {
                result *= radix;
                if(isNegative) {
                    if(-(result + integers[i]) > Integer.MIN_VALUE && -(result + integers[i]) <= 0) {
                        result += integers[i];
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if(result + integers[i] < Integer.MAX_VALUE && result + integers[i] >= 0) {
                        result += integers[i];
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
            } else {
                if(isNegative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        if(isNegative) {
            return result * -1;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("+"));
        System.out.println(myAtoi("-5-"));
        System.out.println(myAtoi(" "));
        System.out.println(myAtoi("000123"));
        System.out.println(myAtoi("-111"));
        System.out.println(myAtoi("3.1415926"));
        System.out.println(myAtoi("       -111"));
        System.out.println(myAtoi("+111"));
        System.out.println(myAtoi("-+111"));
        System.out.println(myAtoi("123 adqw"));
        System.out.println(myAtoi("asd 123"));
        System.out.println(myAtoi("2147483646"));
        System.out.println(myAtoi("-2147483647"));
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi("2147483647"));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("-91283472332"));

        String max = Integer.toString(Integer.MAX_VALUE);
        String min = Integer.toString(Integer.MIN_VALUE);
        System.out.println(max +" , " + min);
    }
}
