package com.leetcode.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * verify that a 9 * 9 Sudoku is valid in horizontal, vertical and 3 * 3 small matrices
 */
public class ValidateEffectiveSudoku {

    public static boolean isValidSudoku(char[][] board) {
        int length = board.length;
        int width = board[0].length;
        Set<Character> xSet = null;
        Set<Character> ySet = null;
        Set<Character>[] mSet = new Set[3];
        for(int i = 0;i < length;i++) {
            xSet = new HashSet<>();
            ySet = new HashSet<>();
            if(i % 3 == 0) {
                mSet[0] = new HashSet<>();
                mSet[1] = new HashSet<>();
                mSet[2] = new HashSet<>();
            }
            for(int j = 0;j < width;j++) {
                if(board[i][j] != '.') {
                    if (xSet.contains(board[i][j])) {
                        return false;
                    } else {
                        xSet.add(board[i][j]);
                    }
                    if (mSet[j / 3].contains(board[i][j])) {
                        return false;
                    } else {
                        mSet[j / 3].add(board[i][j]);
                    }
                }
                if(board[j][i] != '.') {
                    if(ySet.contains(board[j][i])) {
                        return false;
                    } else {
                        ySet.add(board[j][i]);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
