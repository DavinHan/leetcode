package com.test.other;

import java.util.PriorityQueue;

public class RepeatedNTimes {
	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,3};
		int[] b = new int[] {2,1,2,5,3,2};
		int[] c = new int[] {5,1,5,2,5,3,5,4};
		System.out.println(repeatedNTimes(a));
		System.out.println(repeatedNTimes(b));
		System.out.println(repeatedNTimes(c));
	}
	
	public static int repeatedNTimes(int[] A) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int i = 0;
		for(;i < A.length;i++) {
			if(queue.contains(A[i])) {
				break;
			}
			queue.add(A[i]);
		}
		return A[i];
	}
}
