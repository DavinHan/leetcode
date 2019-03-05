package com.test;

public class MaxIncreaseToKeepCitySkyline {	
	
	public static void main(String[] args) {
		int [][]a = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
		System.out.println(maxIncreaseKeepingSkyline(a));
	}
	
	public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int length = grid.length;
		int[] rows = new int[length];
        int[] cols = new int[length];
        for(int i = 0;i < length;i++) {
        	for(int j = 0;j < length;j++) {
        		if(cols[i] < grid[i][j]) {
        			cols[i] = grid[i][j];
        		}
        		if(rows[j] < grid[i][j]) {
        			rows[j] = grid[i][j];
        		}
        	}
        }
        
        int sum = 0;
        for(int i = 0;i < length;i++) {
        	for(int j = 0;j < length;j++) {
        		if(cols[i] > rows[j]) {
        			sum = sum + rows[j] - grid[i][j];
        		}else {
        			sum = sum + cols[i] - grid[i][j];
        		}
        	}
        }
		return sum;
    }
}
