package com.test.other;

public class SortArrayByParityII {
	
	public static void main(String[] args) {
		int[] a = sortArrayByParityII1(new int[] {3,1,4,2});
		String res = "";
		for (int i = 0; i < a.length - 1; i++) {
			res = res + a[i] + ',';
		}
		res += a[a.length - 1];
		System.out.println(res);
	}
	
	public static int[] sortArrayByParityII(int[] A) {
		int a = 0, b = 0;
		int len = A.length;
		int[] aa = new int[len / 2];
		int[] bb = new int[len / 2];
		for(int i = 0;i < len;i++) {
			if(A[i] % 2 == 0) {
				aa[a] = A[i];
				a++;
			}else {
				bb[b] = A[i];
				b++;
			}
		}
		a = 0;
		b = 0;
		for(int i = 0;i < len;i++) {
			if(i % 2 == 0) {
				A[i] = aa[a];
				a++;
			}else {
				A[i] = bb[b];
				b++;
			}
		}
		return A;
	}
	
	public static int[] sortArrayByParityII1(int[] A) {
		int len = A.length - 1;
		int k,tmp;
		for(int i = 0;i < len;i++) {
			if(A[i] % 2 == 0 && i % 2 == 1) {
				k = i;
				while(A[k] % 2 != 1 || k % 2 != 0) {
					k++;
				}
				tmp = A[i];
				A[i] = A[k];
				A[k] = tmp;
			}else if(A[i] % 2 == 1 && i % 2 == 0) {
				k = i;
				while(A[k] % 2 != 0 || k % 2 != 1) {
					k++;
				}
				tmp = A[i];
				A[i] = A[k];
				A[k] = tmp;
			}
		}
		return A;
	}
}
