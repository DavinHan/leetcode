package com.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author yanhanf
 */
public class SpiralOrder2 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int xStart = 0, xEnd = matrix.length - 1,
                yStart = 0, yEnd = matrix[0].length - 1;
        int len = matrix.length * matrix[0].length;

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len;) {
            // 左 -> 右
            for (int j = yStart;j <= yEnd;j++) {
                result.add(matrix[xStart][j]);
                i++;
            }
            xStart++;
            // 上 -> 下
            for (int j = xStart;j <= xEnd;j++) {
                result.add(matrix[j][yEnd]);
                i++;
            }
            yEnd--;
            if(i == len) {
                break;
            }
            // 右 -> 左
            for (int j = yEnd; j >= yStart; j--) {
                result.add(matrix[xEnd][j]);
                i++;
            }
            xEnd--;
            // 下 -> 上
            for (int j = xEnd; j >= xStart; j--) {
                result.add(matrix[j][yStart]);
                i++;
            }
            yStart++;
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(spiralOrder(new int[][]{{1, 2, 3},{4, 5, 6},{7, 8, 9}}));
//        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12}}));
//        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4, 5},{6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4, 5},{6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}}));
    }


}
