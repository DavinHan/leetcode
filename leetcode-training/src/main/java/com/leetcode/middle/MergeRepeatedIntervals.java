package com.leetcode.middle;

import java.util.*;

public class MergeRepeatedIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        List<int[]> merged = new ArrayList<>();
        for(int i = 0;i < intervals.length;i++){
            int l = intervals[i][0], r = intervals[i][1];
            if(merged.size() == 0 || merged.get(merged.size() - 1)[1] < l) {
                merged.add(new int[]{l, r});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], r);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
//        System.out.println("target is [[1,6],[8,10],[15,18]], and test is " + showMatrix(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
//        System.out.println("target is [[1,5]], and test is " + showMatrix(merge(new int[][]{{1, 4}, {4, 5}})));
//        System.out.println("target is [[0,4]], and test is " + showMatrix(merge(new int[][]{{1, 4}, {0, 4}})));
//        System.out.println("target is [[0,4]], and test is " + showMatrix(merge(new int[][]{{1, 4}, {0, 1}})));
//        System.out.println("target is [[1,4]], and test is " + showMatrix(merge(new int[][]{{1,4}, {2,3}})));
//        System.out.println("target is [[1,10]], and test is " + showMatrix(merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}})));

        System.out.println("target is [[1,4]], and test is " + showMatrix(merge(new int[][]{{1,4}, {2,3}})));
    }

    public static String showMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0;i < matrix.length;i++) {
            sb.append("[");
            for(int j = 0;j < matrix[i].length;j++) {
                sb.append(matrix[i][j]);
                if(j < matrix[i].length - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            if(i < matrix.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
