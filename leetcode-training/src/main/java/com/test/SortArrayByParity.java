package com.test;

import java.util.ArrayList;
import java.util.List;

public class SortArrayByParity {
	public static void main(String[] args) {
		int[] a = new int[] {3,1,2,4};
		System.out.println(sortArrayByParity(a));
	}
	
	public static int[] sortArrayByParity(int[] A) {
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		for(int i = 0;i < A.length;i++) {
			if(A[i] % 2 == 0) {
				a.add(A[i]);
			}else {
				b.add(A[i]);
			}
		}
		int m = 0,n = 0;
		for(int i = 0;i < A.length;i++) {
			if(m < a.size()) {
				A[i] = a.get(m);
				m++;
			}else {
				A[i] = b.get(n);
				n++;
			}
		}
		return A;
	}
}
