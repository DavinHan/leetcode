package com.leetcode.middle;

import com.leetcode.common.MatrixUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertUnCovertedIntervals {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int len = intervals.length;
        boolean isAdded = false;
        boolean isAdded2 = false;
        List<int[]> list = new ArrayList<>();
        if(len == 0) {
            list.add(newInterval);
        }
        for (int i = 0;i < len;i++) {
            int[] tmp = new int[2];
            if(newInterval[0] < intervals[i][0] && !isAdded) {
                if (newInterval[1] < intervals[i][0]) {
                    tmp[0] = newInterval[0];
                    tmp[1] = newInterval[1];
                    isAdded = true;
                    i--;
                } else {
                    tmp[0] = newInterval[0];
                    tmp[1] = intervals[i][1];
                    isAdded = true;
                }
            } else {
                tmp = intervals[i];
            }
            if(list.isEmpty()) {
                list.add(tmp);
            } else {
                int last = list.size() - 1;
                if(list.get(last)[1] >= tmp[0]) {
                    list.get(last)[1] = tmp[1];
                } else {
                    list.add(tmp);
                }
            }
        }
        if(!isAdded) {
            int last = list.size() - 1;
            if(list.get(last)[1] >= newInterval[0]) {
                if(list.get(last)[1] <= newInterval[1]) {
                    list.get(last)[1] = newInterval[1];
                }
            } else {
                list.add(newInterval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        System.out.println("target is [[1,5],[6,9]], and test is "
                + MatrixUtil.showMatrix(insert(new int[][]{{1,3},{6,9}}, new int[]{2, 5})));
        System.out.println("target is [[1,2],[3,10],[12,16]], and test is"
                + MatrixUtil.showMatrix(insert(new int[][]{{1,2},{3,5},{6,7}, {8,10},{12,16}}, new int[]{4, 8})));
        System.out.println("target is [[5,7]], and test is"
                + MatrixUtil.showMatrix(insert(new int[][]{}, new int[]{5, 7})));
        System.out.println("target is [[1,5]], and test is"
                + MatrixUtil.showMatrix(insert(new int[][]{{1,5}}, new int[]{2, 3})));
        System.out.println("target is [[1,7]], and test is"
                + MatrixUtil.showMatrix(insert(new int[][]{{1,5}}, new int[]{2, 7})));
    }
}
