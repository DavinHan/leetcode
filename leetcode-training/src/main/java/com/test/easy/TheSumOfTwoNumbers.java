package com.test.easy;

import java.util.HashMap;

/**
 * Find two numbers that are the target and return their subscripts.
 */
public class TheSumOfTwoNumbers {

    public static int[] getTheSubscriptOfTheNumbers(int[] nums, int target) {
        int res[] = new int[2];
        HashMap<Integer, Integer> valueAndPos = new HashMap<>();
        for(int i = 0;i < nums.length;i++) {
            if(valueAndPos.containsKey(target - nums[i])) {
                res[0] = valueAndPos.get(target - nums[i]);
                res[1] = i;
            } else {
                valueAndPos.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = getTheSubscriptOfTheNumbers(new int[]{3, 2, 4}, 16);
        if(res[0] != res[1]) {
            System.out.println(res[0] + ", " + res[1]);
        }else {
            System.out.println(-1);
        }
    }
}
