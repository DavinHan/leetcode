package com.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * find all combinations of the target number in an array without repeated elements
 */
public class FindCombinationsOfTargetInArray {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i < candidates.length;i++) {
            backTrace(candidates[i], target, i, 0, candidates, new ArrayList<>(), result);
        }
        return result;
    }

    public static void backTrace(int t, int target, int pos,
                                 int sum, int[] candidates,
                                 List<Integer> tmp, List<List<Integer>> result) {
        if(t + sum == target) {
            tmp.add(t);
            result.add(tmp);
            return;
        }
        if(t + sum > target) {
            return;
        }
        List<Integer> tt = new ArrayList<>(tmp);
        tt.add(t);
        for(int i = pos;i < candidates.length;i++) {
            backTrace(candidates[i], target, i,t + sum, candidates, tt, result);
        }
    }

    public static void main(String[] args) {
        System.out.println("target is [[7],[2,2,3]] and test is " + combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println("target is [[2,2,2,2],[2,3,3],[3,5]] and test is " + combinationSum(new int[]{2,3,5}, 8));
    }
}
