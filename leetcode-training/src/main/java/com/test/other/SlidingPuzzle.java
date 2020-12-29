package com.test.other;

public class SlidingPuzzle {
	public static void main(String[] args) {
		int[][] board1 = new int[][]{{1,2,3},{4,0,5}};
		int[][] board2 = new int[][] {{1,2,3},{5,4,0}};
		int[][] board3 = new int[][] {{4,1,2},{5,0,3}};
		int[][] board4 = new int[][] {{3,2,4},{1,5,0}};
		System.out.println(slidingPuzzle(board1));
		System.out.println(slidingPuzzle(board2));
		System.out.println(slidingPuzzle(board3));
		System.out.println(slidingPuzzle(board4));
	}
	
	public static int slidingPuzzle(int[][] board) {
		int[][] comp = new int[][] {{1,2,3},{4,5,0}};
		int row = 2,col = 3;
		
		return 0;
	}
}
