package com.leetcode.middle;

/**
 * @author yanhanf
 * @ClassName UniquePathsWithObstacles
 * @Description 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *  机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *  现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *  网格中的障碍物和空位置分别用 1 和 0 来表示。
 * @Date 2021/10/26
 */
public class UniquePathsWithObstacles {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = -1;
                }
            }
        }
        for(int i = m - 1;i >= 0;i--) {
            for(int j = n - 1;j >= 0;j--) {
                if(obstacleGrid[i][j] != 0) {
                    if(i == m - 1 && j == n -1) {
                        obstacleGrid[i][j] = 1;
                    }else if(i == m - 1){
                        obstacleGrid[i][j] = obstacleGrid[i][j + 1];
                    }else if(j == n - 1) {
                        obstacleGrid[i][j] = obstacleGrid[i + 1][j];
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i + 1][j] + obstacleGrid[i][j + 1];
                    }
                }
            }
        }
        return obstacleGrid[0][0];
    }

    public static void main(String[] args) {
        System.out.println("target is 2, test is " + uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0}, {0,0,0}}));
        System.out.println("target is 1, test is " + uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
        System.out.println("target is 0, test is " + uniquePathsWithObstacles(new int[][]{{0,0},{1,1},{0,0}}));
    }
}
