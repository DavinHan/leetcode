package com.leetcode.middle;

/**
 * @author yanhanf
 * @ClassName MinPathSum
 * @Description 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * @Date 2021/10/26
 */
public class MinPathSum {

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = m - 1;i >= 0;i--) {
            for(int j = n - 1;j >= 0;j--) {
                if(i != m - 1 || j != n -1) {
                    if(i == m - 1) {
                        grid[i][j] = grid[i][j] + grid[i][j + 1];
                    } else if (j == n -1) {
                        grid[i][j] = grid[i][j] + grid[i + 1][j];
                    } else {
                        grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
                    }
                }
            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        System.out.println("target is 7, test is " + minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
        System.out.println("target is 12, test is " + minPathSum(new int[][]{{1,2,3},{4,5,6}}));
    }
}
