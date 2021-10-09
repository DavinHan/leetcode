package com.leetcode.middle;

import com.leetcode.common.MatrixUtil;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean isAdd = false;
        for (int[] interval : intervals) {
            if (!isAdd) {
                if (newInterval[0] <= interval[0]) {
                    if (newInterval[1] < interval[0]) {
                        result.add(newInterval);
                        result.add(interval);
                        isAdd = true;
                    } else {
                        if (newInterval[1] <= interval[1]) {
                            newInterval[1] = interval[1];
                        }
                    }
                } else if (newInterval[0] > interval[1]) {
                    result.add(interval);
                } else {
                    newInterval[0] = interval[0];
                    if (newInterval[1] <= interval[1]) {
                        newInterval[1] = interval[1];
                    }
                }
            } else {
                result.add(interval);
            }
        }
        if(!isAdd) {
            result.add(newInterval);
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println("target is [[1,5],[6,9]], and result " + MatrixUtil.showMatrix(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println("target is [[1,2],[3,10],[12,16]] and result is " + MatrixUtil.showMatrix(insert(new int[][]{{1,2}, {3,5},{6,7}, {8,10},{12,16}}, new int[]{4, 8})));
        System.out.println("target is [[2,5]] and result is " + MatrixUtil.showMatrix(insert(new int[][]{}, new int[]{2, 5})));
        System.out.println("target is [[1,5]] and result is " + MatrixUtil.showMatrix(insert(new int[][]{{1, 5}}, new int[]{2, 3})));
        System.out.println("target is [[1,5]] and result is " + MatrixUtil.showMatrix(insert(new int[][]{{2, 3}}, new int[]{1, 5})));
        System.out.println("target is [[1,7]] and result is " + MatrixUtil.showMatrix(insert(new int[][]{{1, 5}}, new int[]{2, 7})));
    }
}
