package com.test;

import java.util.ArrayList;
import java.util.List;

public class MinDeletionSize {
	
	public static void main(String[] args) {
		String[] a = new String[] {"cba","daf","ghi"};
		String[] b = new String[] {"a","b"};
		String[] c = new String[] {"zyx","wvu","tsr"};
		System.out.println(minDeletionSize(a));
		System.out.println(minDeletionSize(b));
		System.out.println(minDeletionSize(c));
	}
	
	public static int minDeletionSize(String[] A) {
		int count = 0;
		int row = A.length, col = A[0].length();
		for(int j = 0;j < col;j++) {
			for(int i = 1;i < row;i++) {
				if(A[i].charAt(j) < A[i - 1].charAt(j)) {
					count++;
					break;
				}
			}
		}
		return count;
	}
}
