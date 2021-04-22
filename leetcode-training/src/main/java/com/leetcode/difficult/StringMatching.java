package com.leetcode.difficult;

/**
 * string matching
 */
public class StringMatching {

    /**
     * @param s count be null or a-z
     * @param p count be null or a-z, or *, or ?, and * means 0 or more characters, and ? means one character.
     * @return
     */
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 1;i <= n;i++) {
            if(p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for(int i = 1;i <= m;i++) {
            for(int j = 1;j <= n;j++) {
                if(p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if(p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println("target is false, and result is " + isMatch("aa", "a"));
        System.out.println("target is true, and result is " + isMatch("aa", "*"));
        System.out.println("target is false, and result is " + isMatch("cb", "?a"));
        System.out.println("target is true, and result is " + isMatch("adceb", "*a*b"));
        System.out.println("target is false, and result is " + isMatch("acdcb", "a*c?b"));
        System.out.println("target is true, and result is " + isMatch("acbcb", "a*b"));
        System.out.println("target is false, and result is " + isMatch("aab", "c*a*b"));
    }
}
