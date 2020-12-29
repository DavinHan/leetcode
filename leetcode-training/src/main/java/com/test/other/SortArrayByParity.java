package com.test.other;

import java.util.ArrayList;
import java.util.List;

public class SortArrayByParity {
	public static void main(String[] args) {
		int[] a = new int[] {0,2,4};
		System.out.println(sortArrayByParity2(a));
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
	
	public static int[] sortArrayByParity2(int[] A) {
		if(A == null) {
			return null;
		}
		int l = 0,r = A.length - 1;
		while(l < r) {
			while(l < A.length && (A[l] & 1) == 0) l++;
			while(r >= 0 && (A[r] & 1) == 1) r--;
			if(l < r) {
				int temp = A[l];
				A[l] = A[r];
				A[r] = temp;
			}
		}
		return A;
	}
}
