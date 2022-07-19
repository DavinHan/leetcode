package com.leetcode.difficult;

import java.util.ArrayList;
import java.util.List;

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
        List<String> mcs = new ArrayList<>();

        return 0;
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
