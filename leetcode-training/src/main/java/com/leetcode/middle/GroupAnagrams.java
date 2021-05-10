package com.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array of strings, the letters ectopic words together.
 * Letter ectopic refer to the letter the same, but different arrangement of string.
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagramsByGroupingBy(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    char[] cs = str.toCharArray();
                    Arrays.sort(cs);
                    return new String(cs);
                })).values());
    }

    public static List<List<String>> groupAnagramsByStream(String[] strs) {
        // str -> intstream -> sort -> collect by StringBuilder
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str ->
                        str.chars().sorted()
                                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString()))
                .values());
    }

    public static void main(String[] args) {
        System.out.println("target is [[ate,eat,tea],[nat,tan],[bat]], and result is "
                + groupAnagramsByGroupingBy(new String[]{"eat", "tea", "tan", "ate", "nat", "bat", "ac"}));
        System.out.println("target is [[''],[b]], and result is "
                + groupAnagramsByGroupingBy(new String[]{"", "b"}));
        System.out.println("target is [[''],['']], and result is "
                + groupAnagramsByGroupingBy(new String[]{"", ""}));
    }
}
