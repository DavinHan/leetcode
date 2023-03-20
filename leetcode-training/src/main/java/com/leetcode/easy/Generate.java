package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            if (i == 1) {
                tmp.add(1);
            } else {
                List<Integer> t = result.get(result.size() - 1);
                for (int j = 0; j < i; j++) {
                    if (j == 0) {
                        tmp.add(t.get(0));
                    } else if (j == i - 1) {
                        tmp.add(t.get(t.size() - 1));
                    } else {
                        tmp.add(t.get(j - 1) + t.get(j));
                    }
                }
            }
            result.add(tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        Generate g = new Generate();
        System.out.println("target is [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]], and test is " + g.generate(5));
        System.out.println("target is [[1]], and test is " + g.generate(1));
    }
}
