package com.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * all combinations of the target number in an array without non-repeatable elements
 */
public class FindCombinationsOfTargetInArrayII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        boolean trace1 = false;
        for(int i = 0;i < candidates.length;i++) {
            if(trace1 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            trace1 = backTrace(target, candidates[i], 0, i, candidates, new ArrayList<>(), result);
        }
        return result;
    }

    public static boolean backTrace(int target, int t, int sum, int pos, int[] candidates, List<Integer> tmp, List<List<Integer>> result) {
        List<Integer> tt = new ArrayList<>(tmp);
        if(t + sum == target) {
            tt.add(t);
            result.add(tt);
            return true;
        }
        if(t + sum > target) {
            return false;
        }
        int len = result.size();
        tt.add(t);
        boolean trace1 = false;
        for(int i = pos + 1;i < candidates.length;i++) {
            if(trace1 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            trace1 = backTrace(target, candidates[i], t + sum, i, candidates, tt, result);
        }
        return len != result.size();
    }

    public static void main(String[] args) {
        System.out.println("target is [[1,2,2],[5]]  and test is " + combinationSum2(new int[]{2,5,2,1,2}, 5));
        System.out.println("target is [[1, 7],[1, 2, 5],[2, 6],[1, 1, 6]] and test is " + combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
