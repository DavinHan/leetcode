package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            if (i == 1) {
                tmp.add(1);
            } else {
                List<Integer> t = result.get(result.size() - 1);

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
