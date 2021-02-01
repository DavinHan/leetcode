package com.test.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert a roman to a integer.
 */
public class RomanToInt {

    private static final Map<Character, Integer> roman = new HashMap<>(8);

    static {
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
    }

    public static int convertRomanToInt(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        int res = 0;
        for(int i = 0;i < len;i++) {
            if(i < len - 1 && roman.get(cs[i]) < roman.get(cs[i + 1])) {
                res = res - roman.get(cs[i]);
            } else {
                res = res + roman.get(cs[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(convertRomanToInt("III"));
        System.out.println(convertRomanToInt("IV"));
        System.out.println(convertRomanToInt("XL"));
        System.out.println(convertRomanToInt("CM"));
    }
}
