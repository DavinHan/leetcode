package com.leetcode.middle;

import com.leetcode.common.MatrixUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yanhanf
 * @Description TODO
 * @ClassName MatrixSetZeroes
 * @Date 2021/11/30
 */
public class MatrixSetZeroes {

    public static void setZeroes(int[][] matrix) {
        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                if(matrix[x][y] == 0) {
                    xSet.add(x);
                    ySet.add(y);
                }
            }
        }
        for (Integer x : xSet) {
            Arrays.fill(matrix[x], 0);
        }
        for (Integer y : ySet) {
            for(int j = 0;j < matrix.length;j++){
                matrix[j][y] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m1 = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(m1);
        System.out.println("target is [[1,0,1],[0,0,0],[1,0,1]], test is " + MatrixUtil.showMatrix(m1));
        int[][] m2 = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(m2);
        System.out.println("target is [[0,0,0,0],[0,4,5,0],[0,3,1,0]], test is " + MatrixUtil.showMatrix(m2));
    }
}
