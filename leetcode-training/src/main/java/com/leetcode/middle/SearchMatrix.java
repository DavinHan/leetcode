package com.leetcode.middle;

/**
 * @author yanhanf
 * @Description TODO
 * @ClassName SearchMatrix
 * @Date 2021/11/30
 */
public class SearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int xLen = matrix.length, yLen = matrix[0].length;
        for(int i = 0;i < xLen;i++) {
            if(target < matrix[i][0]) {
                if(i == 0) {
                    return false;
                }
                for(int j = 0;j < yLen;j++) {
                    if(target == matrix[i - 1][j]) {
                        return true;
                    }
                }
            }
        }
        for(int j = 0;j < yLen;j++) {
            if(target == matrix[xLen - 1][j]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("target is true, test is " + searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println("target is false, test is " + searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
        System.out.println("target is true, test is " + searchMatrix(new int[][]{{1}}, 1));;
        System.out.println("target is true, test is " + searchMatrix(new int[][]{{1, 3}}, 1));
        System.out.println("target is true, test is " + searchMatrix(new int[][]{{1, 3}}, 3));
        System.out.println("target is false, test is " + searchMatrix(new int[][]{{1, 3}}, 2));
        System.out.println("target is true, test is " + searchMatrix(new int[][]{{1}, {3}}, 1));
        System.out.println("target is true, test is " + searchMatrix(new int[][]{{1}, {3}}, 3));
        System.out.println("target is false, test is " + searchMatrix(new int[][]{{1}, {3}}, 2));
    }
}
