package com.leetcode.middle;

/**
 * determine if the Suduku is solvable
 */
public class DetermineIfSudukuIsSolvable {

    public static void solveSudoku(char[][] board) {
        backTrace(board, 0, 0);
    }

    public static boolean backTrace(char[][] board, int row, int col) {
        if(row == board.length) {
            return true;
        }
        if(col == board[0].length) {
            return backTrace(board, row + 1, 0);
        }
        if(board[row][col] != '.') {
            return backTrace(board, row, col + 1);
        }
        for(int i = '1';i <= '9';i++) {
            if(!checkUnique(board, row, col, (char) i)) {
                continue;
            }
            board[row][col] = (char) i;
            if(backTrace(board, row, col)) {
                return true;
            }
            // 1 - 9挨个试试
            board[row][col] = '.';
        }
        return false;
    }

    public static boolean checkUnique(char[][] board,int row, int col, char n) {
        for(int i = 0;i < 9;i++) {
            if(board[row][i] == n || board[i][col] == n) {
                return false;
            }
            if(board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == n) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
