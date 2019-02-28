package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SolveNQueens {
	
	public static void main(String[] args) {
		int n = 4;
		List<List<String>> list = solveNQueens1(n);
		for(int i = 0;i < n;i++) {
			String temp = "";
			for(int j = 0;j < n;j++) {
				temp += list.get(i).get(j);
			}
			System.out.println(temp);
		}
	}
	
	@Deprecated
	public static List<List<String>> solveNQueens1(int n){
		List<List<String>> result = new ArrayList<>(n);
		StringBuilder sb = new StringBuilder();
		byte[] b = new byte[n];
		for(int i = 0;i < n;i++) {
			b[i] = 0;
		}
		Stack<Integer> q = new Stack<>();
		Stack<Integer> s = new Stack<>();
		int w = 0;
		int h = 0;
		boolean fl = false;
		int k = 0;
		while(k < n) {
			List<String> list = new ArrayList<>(n);
			w = k;
			while(h < n) {
				while(w >= 0 && w < n) {
					if(b[w] == 0) {
						if(w == n - 1) {
							fl = true;
							break;
						}
						if(b[w + 1] == 1 && w == 0) {
							w += 1;
							continue;
						}else if(b[w + 1] == 1 || w != 0 && b[w - 1] == 1) {
							w += 1;
							continue;
						}else {
							fl = true;
							break;
						}
					}else {
						w++;
					}
				}
				if(fl == false) {
					b[w = q.pop()] = 0;
					w++;
					if(h != 0) {
						h--;
					}
					if(w == 4) {
						h--;
						b[w = q.pop()] = 0;
						w++;
					}
				}else {
					b[w] = 1;
					q.push(w);
					h++;
					w = 0;
				}
				fl = false;
			}
			for(int i = 0;i < n;i++) {
				b[i] = 0;
			}
			while(!q.isEmpty()) {
				s.push(q.pop());
			}
			k = s.peek();
			while(!s.isEmpty()) {
				for(int j = 0;j < n;j++) {
					if(j == s.peek()) {
						sb.append("Q");
					}else {
						sb.append(".");
					}
				}
				s.pop();
				list.add(sb.toString());
				sb.delete(0, n);
			}
			result.add(list);
			k++;
		}
		return result;
	}
}
