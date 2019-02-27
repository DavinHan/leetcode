package com.test;

import java.util.Stack;

public class FlipAndInvertImage {
	public static void main(String[] args) {
		int[][] a = new int[][] {{1,1,0},{1,0,1},{0,0,0}};
		int[][] b = new int[][] {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
		System.out.println(flipAndInvertImage(a));
		System.out.println(flipAndInvertImage(b));
	}
	
	public static int[][] flipAndInvertImage(int[][] A){
		int r = A.length;
		int l = A[0].length;
		Stack<Integer> s = new Stack<>();
		int[][] result = new int[r][l];
		for(int i = 0;i < r;i++) {
			for(int j = 0;j < l;j++) {
				s.push(A[i][j]);
			}
			int k = 0;
			while(!s.isEmpty()) {
				int tmp = s.pop();
				if(tmp == 0) {
					result[i][k] = 1;
				}else {
					result[i][k] = 0;
				}
				k++;
			}
		}
		return result;
	}
}
