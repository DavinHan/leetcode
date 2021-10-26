package com.leetcode.middle;

/**
 * @author yanhanf
 * @ClassName UniquePaths
 * @Description 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *  机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。问总共有多少条不同的路径？
 * @Date 2021/10/26
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for(int i = 0;i < n;i++){
            arr[0][i] = 1;
        }
        for(int i = 0;i < m;i++){
            arr[i][0] = 1;
        }
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println("target is 28, test is " + uniquePaths(3, 7));
        System.out.println("target is 3, test is " + uniquePaths(3, 2));
        System.out.println("target is 28, test is " + uniquePaths(7, 3));
        System.out.println("target is 6, test is " + uniquePaths(3, 3));
        System.out.println("target is 1, test is " + uniquePaths(1, 1));
    }
}
