package com.leetcode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * letter combination in phone number.
 */
public class LetterCombinationInPhoneNumber {

    private static Map<Integer, char[]> map = new HashMap<>(16);

    static {
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || "".equals(digits)) {
            return result;
        }
        dfs(new StringBuilder(), result, digits.length(), digits, 0);
        return result;
    }

    public static void dfs(StringBuilder sb, List<String> result, int height, String digits, int pos){
        if(sb.length() == height) {
            result.add(sb.toString());
            return;
        } else {
            char[] chars = map.get((int)digits.charAt(pos) - 48);
            for(int i = 0;i < chars.length;i++) {
                sb.append(chars[i]);
                dfs(sb, result, height, digits, pos + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("22"));
        System.out.println(letterCombinations("23"));
    }
}
