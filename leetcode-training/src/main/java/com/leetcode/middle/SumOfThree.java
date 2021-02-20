package com.leetcode.middle;

import java.util.*;

/**
 * Find the sum of three number to be 0.
 */
public class SumOfThree {

    /**
     * three pointers
     * @param nums
     * @return
     */
    public static List<List<Integer>> sumOfThreeByPointer(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0;i < len;i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    while(l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    while(l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    r--;
                    l++;
                } else {
                    if(sum > 0) {
                        r -= 1;
                    } else {
                        l += 1;
                    }
                }
            }
        }

        return result;
    }

    public static List<List<Integer>> sumOfThreeByHashTable(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> tmp = new HashMap<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0;i < len;i++) {
            tmp.put(nums[i], i);
        }
        for(int i = 0;i < len;i++) {
            // deduplication
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j = i + 1;j < len;j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int target = -nums[i] - nums[j];
                if(tmp.containsKey(target) && tmp.get(target) > j) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], target)));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(sumOfThreeByPointer(new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));
        System.out.println(sumOfThreeByHashTable(new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));
    }
}
