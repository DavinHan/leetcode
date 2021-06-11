package com.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int len = matrix.length * matrix[0].length;
        int direction = 0; // 0 左移，1 下移，2 右移，3 上移
        int x = 0, y = 0;
        int xm = -1, xM = matrix[0].length, ym = 0, yM = matrix.length;
        for(int i = 0;i < len;i++) {
            switch (direction) {
                case 0:
                    result.add(matrix[y][x++]);
                    if(x == xM) {
                        direction = 1;
                        xM--;
                        x--;
                        y++;
                    }
                    break;
                case 1:
                    result.add(matrix[y++][x]);
                    if(y == yM) {
                        direction = 2;
                        yM--;
                        y--;
                        x--;
                    }
                    break;
                case 2:
                    result.add(matrix[y][x--]);
                    if(x == xm) {
                        direction = 3;
                        xm++;
                        x++;
                        y--;
                    }
                    break;
                case 3:
                    result.add(matrix[y--][x]);
                    if(y == ym) {
                        direction = 0;
                        ym++;
                        y++;
                        x++;
                    }
                    break;
            }
        }
        return result;
    }

    public static List<Integer> spiralOrderII(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 依次对应左、下、右、上
        int directionIndex = 0;
        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = 0;
        int len = rows * cols;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0;i < len;i++) {
            result.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + directions[directionIndex][0], nextCol = col + directions[directionIndex][1];
            if(nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("target is [1,2,3,6,9,8,7,4,5]," +
                "test is " + spiralOrderII(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}}));
        System.out.println("target is [1,2,3,4,8,12,11,10,9,5,6,7]," +
                "test is " + spiralOrderII(new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}}));
    }
}
