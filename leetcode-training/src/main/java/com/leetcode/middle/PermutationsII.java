package com.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        permute(result, nums, new boolean[nums.length], new ArrayList<>());
        return result;
    }

    public static void permute(List<List<Integer>> result,
                               int[] nums,
                               boolean[] isUsed,
                               List<Integer> tmp) {
        int n = nums.length;
        if(tmp.size() == n) {
            result.add(new ArrayList<>(tmp));
            return;
        } else {
            for(int i = 0;i < n;i++) {
                if(!isUsed[i] && (i == 0 || nums[i] != nums[i - 1] || isUsed[i - 1])) {
                    isUsed[i] = true;
                    tmp.add(nums[i]);
                    permute(result, nums, isUsed, tmp);
                    tmp.remove(tmp.size() - 1);
                    isUsed[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("target is [[1,1,1]], and result is " + permuteUnique(new int[]{1, 1, 1}));
        System.out.println("target is [[1,1,2],[1,2,1],[2,1,1]], and result is " + permuteUnique(new int[]{1, 1, 2}));
        System.out.println("target is [[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,1,2,1],[2,2,1,1]], and result is " + permuteUnique(new int[]{1, 1, 2, 2}));
        System.out.println("target is [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]], and result is " + permuteUnique(new int[]{1, 2, 3}));
    }
}
