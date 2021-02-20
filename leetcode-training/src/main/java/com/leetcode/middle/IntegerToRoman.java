package com.leetcode.middle;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Convert a integer to a roman.
 */
public class IntegerToRoman {

    private static final Map<Integer, String> roman = new LinkedHashMap<>(16);

    static {
        roman.put(1000, "M");
        roman.put(900, "CM");
        roman.put(500, "D");
        roman.put(400, "CD");
        roman.put(100, "C");
        roman.put(90, "XC");
        roman.put(50, "L");
        roman.put(40, "XL");
        roman.put(10, "X");
        roman.put(9, "IX");
        roman.put(5, "V");
        roman.put(4, "IV");
        roman.put(1, "I");
    }

    public static String convertIntegerToRoman(int num){
        Iterator<Map.Entry<Integer, String>> iterator = roman.entrySet().iterator();
        String romanRes = "";
        Map.Entry<Integer, String> r = iterator.next();
        while(num > 0) {
            if(r.getKey() <= num) {
                num -= r.getKey();
                romanRes += r.getValue();
            } else {
                if(iterator.hasNext()) {
                    r = iterator.next();
                }
            }
        }
        return romanRes;
    }

    public static void main(String[] args) {
        System.out.println(convertIntegerToRoman(5));
        System.out.println(convertIntegerToRoman(4));
        System.out.println(convertIntegerToRoman(10));
    }
}
