package com.leetcode.difficult;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
 * 你可以对一个单词进行如下三种操作： 
 *
 * 插入一个字符 
 * 删除一个字符 
 * 替换一个字符 
 *
 * @author yanhanf
 */
public class MinDistance {

    public int minDistance(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int[][] cm = new int[c1.length + 1][c2.length + 1];
        for(int i = 0;i < cm.length;i++) {
            cm[i][0] = i;
        }
        for(int j = 0;j < cm[0].length;j++) {
            cm[0][j] = j;
        }
        for(int i = 1;i < cm.length;i++) {
            for(int j = 1;j < cm[0].length;j++) {
                cm[i][j] = Math.min(Math.min(cm[i][j - 1], cm[i - 1][j]), cm[i - 1][j - 1]) + 1;
                if(c1[i - 1] == c2[j - 1]) {
                    cm[i][j] = Math.min(cm[i][j], cm[i - 1][j - 1]);
                }
            }
        }
        return cm[c1.length][c2.length];
    }

    public static void main(String[] args) {
        MinDistance d = new MinDistance();
        /*
         * horse ros
         * rorse
         * rose
         * ros
         */
        System.out.println("target is 3, and test is " + d.minDistance("horse", "ros"));
        /*
         * intention execution
         * intection
         * intecution
         * ntecution
         * etecution
         * execution
         */
        System.out.println("target is 5, and test is " + d.minDistance("intention", "execution"));
    }
}
