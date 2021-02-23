package com.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * find sum of four integer is target
 */
public class SumOfFour {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<String> res = new ArrayList<>();
        Arrays.sort(nums);
        int l, r;
        int len = nums.length;
        int sum = 0;
        for (int i = 0;i < len;i++) {
            for(int j = i + 1;j < len;j++) {
                StringBuilder sb = new StringBuilder();
                l = j + 1;
                r = len - 1;
                while (l < r) {
                    if((sum = nums[i] + nums[j] + nums[l] + nums[r]) == target) {
                        sb.append(nums[i]).append(",").append(nums[j]).append(",").append(nums[l]).append(",").append(nums[r]);
                        if(!res.contains(sb.toString())) {
                            res.add(sb.toString());
                        }
                        sb = new StringBuilder();
                        l++;
                        r--;
                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        for(String s : res) {
            String[] ss = s.split(",");
            result.add(new ArrayList<>(Arrays.asList(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]), Integer.parseInt(ss[2]), Integer.parseInt(ss[3]))));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0));
    }
}
