package com.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        permute(nums, new ArrayList<>(), result, isVisited);
        return result;
    }

    public static void permute(int[] nums, List<Integer> tmp,
                                              List<List<Integer>> result,
                                              boolean[] isVisit) {
        if(tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
        } else {
            for(int i = 0;i < nums.length;i++) {
                if(isVisit[i]) {
                    continue;
                } else {
                    isVisit[i] = true;
                    tmp.add(nums[i]);
                    permute(nums, tmp, result, isVisit);
                    isVisit[i] = false;
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("target is [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]], and result is " + permute(new int[]{1, 2, 3}));
    }
}
