package com.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * think generate as a tree
 */
public class GenerateNGroupParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, result, "",0, n);
        return result;
    }

    private static void dfs(int n, List<String> result, String tmp, int left, int rifht){
        if(tmp.length() == n * 2) {
            result.add(tmp);
            return;
        }
        if(left < n) {
            dfs(n, result, tmp + "(", left + 1, rifht - 1);
        }
        if(rifht < n) {
            dfs(n, result, tmp + ")", left, rifht + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(0));
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));

    }
}
