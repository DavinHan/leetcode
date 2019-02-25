package com.test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class 有序数组的平方 {

	public static void main(String[] args) {
		int[]A = {-4,-1,0,3,10};
		int[]B = {-7,-3,1,3,11};
		int[]a = new int[A.length];
		a = sortedSquares(A);
		int[]b = new int[B.length];
		b = sortedSquares(B);
		for (int i : a) {
			System.out.println(i);
		}
		System.out.println("...");
		for (int i : b) {
			System.out.println(i);
		}
	}
	
	public static int[] sortedSquares(int[]A) {
		int length = A.length;
		if(A.length<=0) {
			return null;
		}
		Queue<Integer> queue = new PriorityQueue<>(length);
		if(A[0] < 0) {
			for(int i = 0;i < length;i++) {
				if(A[i] < 0) {
					queue.add(A[i] * -1);
				}else {
					queue.add(A[i]);
				}
			}
		}else {
			for (Integer i : A) {
				queue.add(i);
			}
		}
		int[]B = new int[length];
		for(int j = 0;j < length;j++) {
			B[j] = (int) Math.pow(queue.poll(), 2);
		}
		return B;
	}
}
