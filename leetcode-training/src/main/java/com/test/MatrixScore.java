package com.test;

public class MatrixScore {

	public static void main(String[] args) {
		int[][] A = new int[][] {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
		int[][] B = new int[][] {{0,1},{1,1}};
		MatrixScore ms = new MatrixScore();
		System.out.println(ms.matrixScore(B));
	}
	
    public int matrixScore(int[][] A) {
    	int row = A.length, col = A[0].length;
    	if(row < 1) {
    		return 0;
    	}else {
    		for(int i = 0;i < row;i++) {
    			if(A[i][0] == 0) {
    				for(int j = 0;j < col;j++) {
    					A[i][j] = A[i][j] == 0 ? 1 : 0;
    				}
    			}
    		}
			for(int j = 0;j < col;j++) {
				int count = 0;
				for(int i = 0;i < row;i++) {
					if(A[i][j] == 0) {
						count++;
					}
				}
				if(count > row / 2) {
					for(int i = 0;i < row;i++) {
						A[i][j] = A[i][j] == 0 ? 1 : 0;
					}
				}
			}
    	}
    	int sum = 0;
    	for(int i = 0;i < row;i++) {
			for(int j = 0;j < col;j++) {
				sum = sum + (A[i][j] == 0 ? 0 : (int) (Math.pow(2, A[i][j] * (col - j - 1))));
			}
		}
    	return sum;
    }
}