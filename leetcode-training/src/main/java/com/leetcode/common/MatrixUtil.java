package com.leetcode.common;

public class MatrixUtil {

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
