package com.leetcode.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * The shortest contiguous sub-array with the same size of degree, return its length
 */
public class DegreeOfArray {

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++) {
            if(!map.containsKey(nums[i])) {
                int[] arr = new int[]{1, i, i};
                map.put(nums[i], arr);
            } else {
                int[] arr = map.get(nums[i]);
                arr[0] += 1;
                arr[2] = i;
            }
        }
        Iterator<Map.Entry<Integer, int[]>> iter = map.entrySet().iterator();
        int maxV = -1;
        int result = 0;
        while(iter.hasNext()) {
            Map.Entry<Integer, int[]> en = iter.next();
            if(en.getValue()[0] > maxV) {
                maxV = en.getValue()[0];
                result = en.getValue()[2] - en.getValue()[1] + 1;
            } else if(en.getValue()[0] == maxV && (en.getValue()[2] - en.getValue()[1] + 1 < result)) {
                maxV = en.getValue()[0];
                result = en.getValue()[2] - en.getValue()[1] + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{0}));
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(findShortestSubArray(new int[]{47,47,72,47,72,47,79,47,12,92,13,47,47,83,33,15,18,47,47,47,47,64,47,65,47,47,47,47,70,47,47,55,47,15,60,47,47,47,47,47,46,30,58,59,47,47,47,47,47,90,64,37,20,47,100,84,47,47,47,47,47,89,47,36,47,60,47,18,47,34,47,47,47,47,47,22,47,54,30,11,47,47,86,47,55,40,49,34,19,67,16,47,36,47,41,19,80,47,47,27}));
    }
}
