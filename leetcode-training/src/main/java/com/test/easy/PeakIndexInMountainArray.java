package com.test.easy;

public class PeakIndexInMountainArray {
    
	public static void main(String[] args) {
		int[] a = new int[] {0,1,0};
		int[] b = new int[] {0,2,1,0};
		int[] c = new int[] {24,69,100,99,79,78,67,36,26,19};
		System.out.println(peakIndexInMountainArray2(a));
		System.out.println(peakIndexInMountainArray2(b));
		System.out.println(peakIndexInMountainArray2(c));
	}
	
	public static int peakIndexInMountainArray(int[] A) {
		int max = 0, pos = 0;
		int len = A.length;
		for(int i = 0;i < len;i++) {
			if(max < A[i]) {
				max = A[i];
				pos = i;
			}
		}
    	return pos;
    }
	
	public static int peakIndexInMountainArray1(int []A) {
		int pos = 0, len = A.length;
		for(int i = 1;i < len;i++) {
			if(A[i] < A[i - 1]) {
				pos = i - 1;
				break;
			}
		}
		return pos;
	}
	
	public static int peakIndexInMountainArray2(int []A) {
		int pos = 0, left = 0, right = A.length;
		while(left < right) {
			pos = (left + right) >> 1;
			if(A[pos] > A[pos + 1] && A[pos] > A[pos - 1]) {
				break;
			}else if(A[pos] > A[pos + 1]) {
				right = pos;
			}else {
				left = pos + 1;
			}
		}
		return pos;
	}
}
