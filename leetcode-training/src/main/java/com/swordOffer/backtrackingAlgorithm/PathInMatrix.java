package com.swordOffer.backtrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem: find a path in the matrix containing all the characters
 * in the given string, and the length of the path is equal to the
 * length of the length of the string.
 */
public class PathInMatrix {

    private int xLen;
    private int yLen;
    private char[][] matrix;
    private boolean[][] isWalked;
    private String target;

    public boolean findPathInMatrix(char[][] matrix, String target) {
        this.xLen = matrix.length;
        this.yLen = matrix[0].length;
        this.isWalked = new boolean[xLen][yLen];
        this.matrix = matrix;
        this.target = target;

        for(int i = 0;i < xLen;i++) {
            for(int j = 0;j < yLen;j++) {
                char[] tmp = new char[target.length()];
                if(!isWalked[i][j] && travelMatrix(i, j, tmp)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean travelMatrix(int startX, int startY, char[] tmp) {
        if(startX < 0 || startX >= xLen || startY < 0 || startY >= yLen) {
            return false;
        }

        // up
        if(startX - 1 > 0 && !isWalked[startX - 1][startY] && target.contains(matrix[startX - 1][startY] + "")) {
            isWalked[startX - 1][startY] = true;
        }
        // left
        if(startY - 1 > 0 && !isWalked[startX][startY - 1] && target.contains(matrix[startX][startY - 1] + "")) {
            isWalked[startX][startY - 1] = true;
        }
        // down
        if(startX + 1 < xLen && !isWalked[startX + 1][startY] && target.contains(matrix[startX + 1][startY] + "")) {
            isWalked[startX + 1][startY] = true;
        }
        // right
        if(startY + 1 < yLen && !isWalked[startX][startY + 1] && target.contains(matrix[startX][startY + 1] + "")) {
            isWalked[startX][startY + 1] = true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("c87e2267-1001-4c70-bb2a-ab41f3b81aa3".length());
    }
}
