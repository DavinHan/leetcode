package com.leetcode.middle;

import java.util.Arrays;

/**
 * For a given n * n matrix, rotate it 90 degrees clockwise.
 */
public class MatrixRotation {

    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0;i < len - 1 - i;i++) {
            for(int j = i;j < len - 1 - i;j++) {
                int left = i, right = len - i - 1; // 0, 2;0, 2;1, 1
                int top = j, button = len - j - 1; // 0, 2;1, 1;1, 1

                int tmp = matrix[top][right];
                matrix[top][right] = matrix[left][top];
                matrix[left][top] = matrix[button][left];
                matrix[button][left] = matrix[right][button];
                matrix[right][button] = tmp; // matrix[left][button]
            }
        }
    }

    public static void main(String[] args) {
        int[][] a1 = new int[][]{{1,2,3}, {4,5,6},{7,8,9}};
        System.out.println("target is [[7,4,1],[8,5,2],[9,6,3]]");
        rotate(a1);
        System.out.println("result is " + showMatrix(a1));

        int[][] a2 = new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        System.out.println("target is [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]");
        rotate(a2);
        System.out.println("result is " + showMatrix(a2));

        int[][] a3 = new int[][]{{1}};
        System.out.println("target is [[1]]");
        rotate(a3);
        System.out.println("result is " + showMatrix(a3));

        int[][] a4 = new int[][]{{1,2},{3,4}};
        System.out.println("target is [[3,1],[4,2]]");
        rotate(a4);
        System.out.println("result is " + showMatrix(a4));

        int[][] a5 = new int[][]{{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8},{5,6,7,8,9}};
        System.out.println("target is [[3,1],[4,2]]");
        rotate(a5);
        System.out.println("result is " + showMatrix(a5));
    }

    public static String showMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0;i < matrix.length;i++) {
            sb.append("[");
            for (int j = 0;j < matrix[0].length;j++) {
                sb.append(matrix[i][j]);
                if(j < matrix[0].length - 1) {
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
