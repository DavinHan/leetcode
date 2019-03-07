package com.test;

public class GenerateMatrix {

	public static void main(String[] args) {
		int n = 4;
		int a[][] = generateMatrix(n);
		for(int i = 0;i < n;i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0;j < n;j++) {
				sb.append(a[i][j]).append(" ");
			}
			System.out.println(sb.toString());
		}
	}
	
	public static int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int upleft = 1;
		int upright = n - 1;
		int downleft = 0;
		int downright = n - 1;
		int row = 0 , col = 0;
		res[0][0] = 1;
		boolean up = true;
		boolean right = true;
		int limit = n * n;
		while(res[row][col] != limit) {
			if(up == true && right == true) {
				//右
				for(int i = col + 1;i <= upright;i++) {
					res[row][i] = res[row][i - 1] + 1;
				}
				col = upright;
				upright--;
				up = false;
				right = false;
			}else if(up == true && right == false) {
				//左
				for(int i = col - 1;i >= downleft;i--) {
					res[row][i] = res[row][i + 1] + 1;
				}
				col = downleft;
				downleft++;
				up = false;
				right = true;
			}else if(up == false && right == true) {
				//上
				for(int i = row - 1;i >= upleft;i--) {
					res[i][col] = res[i + 1][col] + 1;
				}
				row = upleft;
				upleft++;
				up = true;
			}else {
				//下
				for(int i = row + 1;i <= downright;i++) {
					res[i][col] = res[i - 1][col] + 1;
				}
				row = downright;
				downright--;
				up = true;
				right = false;
			}
		}
		return res;
	}
}
