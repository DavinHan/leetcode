package com.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 *
 *  要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 *
 *  "AAJF" ，将消息分组为 (1 1 10 6)
 *  "KJF" ，将消息分组为 (11 10 6)
 *
 *
 *  注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 *  给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 *  题目数据保证答案肯定是一个 32 位 的整数。
 *
 * @author yanhanf
 */
public class NumDecoding {

    // 动态规划，向后填表
    public int numDecoding(String s) {
        int n = s.length();
        s = " " + s;
        char[] cs = s.toCharArray();
        int[] tab = new int[3];
        tab[0] = 1;
        for(int i = 1;i <= n;i++) {
            tab[i % 3] = 0;
            int a = cs[i] - '0', b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            if(0 < a && a < 10) {
                tab[i % 3] = tab[(i - 1) % 3];
            }
            if(9 < b && b < 27) {
                tab[i % 3] += tab[(i - 2) % 3];
            }
        }
        return tab[n % 3];
    }

    // 递归正向查询，遍历
    public int numDecoding2(String s) {
        char[] cs = s.toCharArray();
        List<List<Integer>> sums = new ArrayList<>();
        numDecoding2(sums, new ArrayList<>(), cs, s, 0);
        return sums.size();
    }

    private void numDecoding2(List<List<Integer>> sums, List<Integer> tmp, char[] cs, String s, int i) {
        if(i == s.length()) {
            sums.add(tmp);
            return;
        }
        List<Integer> t = new ArrayList<>(tmp);
        int k = cs[i] - 48;
        if(k > 0 && k < 27) {
            t.add(k);
            numDecoding2(sums, t, cs, s, i + 1);

            if(k < 3 && i < cs.length - 1) {
                List<Integer> tt = new ArrayList<>(tmp);
                k = Integer.parseInt(s.substring(i, i + 2));
                if(k > 0 && k < 27) {
                    tt.add(k);
                    numDecoding2(sums, tt, cs, s, i + 2);
                }
            }
        }
    }

    public static void main(String[] args) {
        NumDecoding d = new NumDecoding();
        System.out.println("target is 1, and test is " + d.numDecoding("2101"));
        System.out.println("target is 1, and test is " + d.numDecoding("10"));
        // 1,2 | 12
        System.out.println("target is 2, and test is " + d.numDecoding("12"));
        // 1,2 | 12
        System.out.println("target is 1, and test is " + d.numDecoding("27"));
        // 2,2,6 | 22,6 | 2,26
        System.out.println("target is 3, and test is " + d.numDecoding("226"));
        // 无
        System.out.println("target is 0, and test is " + d.numDecoding("0"));
        // 无
        System.out.println("target is 0, and test is " + d.numDecoding("1201234"));
        // 无
        System.out.println("target is 0, and test is " + d.numDecoding("111111111111111111111111111111111111111111111"));
    }
}
