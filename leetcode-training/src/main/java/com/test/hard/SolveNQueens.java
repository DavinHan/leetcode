package com.test.hard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class SolveNQueens {
	
	public static void main(String[] args) {
		int n = 5;
		List<List<String>> list = solveNQueens3(n);
		for(int i = 0;i < list.size();i++) {
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
	
	// 解法：
	// https://blog.csdn.net/hackbuteer1/article/details/6657109
	// 解法1：
	public static List<List<String>> solveNQueens2(int n){
		List<List<String>> result = new ArrayList<>();
		if(n < 1) {
			return null;
		}
		if(n == 1) {
			List<String> list = new ArrayList<>();
			list.add("Q");
			result.add(list);
			return result;
		}
		int col = 0, row = 0;
		byte[][] map = new byte[n][n];
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < n;j++) {
				map[i][j] = 0;
			}
		}
		while(true) {
			if(isSatisfy(map, row, col) == true) {
				map[row][col] = 1;
				if(row == n - 1) {
					List<String> list = new ArrayList<>();
					for(int i = 0;i < n;i++) {
						String tmp = "";
						for(int j = 0;j < n;j++) {
							if(map[i][j] == 1) {
								tmp += "Q";
							}else {
								tmp += ".";
							}
						}
						list.add(tmp);
					}
					result.add(list);
					if(col < n - 1) {
						col++;
					}else {
						while(col >= n - 1) {
							for(int i = 0;i < n;i++) {
								map[row][i] = 0;
							}
							row--;
							for(int i = 0;i < n;i++) {
								if(map[row][i] == 1) {
									col = i + 1;
									break;
								}
							}
							for(int i = 0;i < n;i++) {
								map[row][i] = 0;
							}
							if(col == n - 1) {
								break;
							}
						}
					}
				}else {
					row++;
					col = 0;
				}
			}else {
				if(col < n - 1) {
					col++;
				}else {
					if(row == 0) {
						break;
					}else {
						while(col >= n - 1) {
							for(int i = 0;i < n;i++) {
								map[row][i] = 0;
							}
							row--;
							if(row < 0) {
								break;
							}
							for(int i = 0;i < n;i++) {
								if(map[row][i] == 1) {
									col = i + 1;
									break;
								}
							}
							for(int i = 0;i < n;i++) {
								map[row][i] = 0;
							}
							if(col == n - 1) {
								break;
							}
						}
					}
					if(row < 0) {
						break;
					}
				}
			}
		}
		return result;
	}
	
	public static boolean isSatisfy(byte[][] map, int row, int col) {
		for(int i = 0;i < row;i++) {
			if(map[i][col] == 1) {
				return false;
			}
		}
		for(int i = row, j = col;i >= 0 && j >= 0;i--, j--) {
			if(map[i][j] == 1) {
				return false;
			}
		}
		for(int i = row, j = col;i >= 0 && j < map.length;i--, j++) {
			if(map[i][j] == 1) {
				return false;
			}
		}
		return true;
	}
	
	
	// 解法3：
	public static List<List<String>> solveNQueens3(int n){
		if(n < 1) {
			return null;
		}
		List<List<String>> result = new ArrayList<>(n);
		if(n == 1) {
			List<String> list = new ArrayList<>();
			list.add("Q");
			result.add(list);
			return result;
		}
		int[] map = new int[n];
		for (int i = 0; i < n; i++) {
			map[i] = -1;
		}
		int col = 0, row = 0;
		while(true) {
			if(map[row] == -1 && isSatisfy2(map, col, row, n) == true) {
				map[row] = col;
				if(row == n - 1) {
					List<String> list = new ArrayList<>();
					for (int i = 0; i < n; i++) {
						String tmp = "";
						for(int j = 0;j < n;j++) {
							if(j == map[i]) {
								tmp += "Q";
							}else {
								tmp += ".";
							}
						}
						list.add(tmp);
					}
					result.add(list);
					
					if(col == n - 1) {
						while(col >= n - 1) {
							map[row] = -1;
							row--;
							col = map[row] + 1;
							map[row] = -1;
							if(col == n - 1) {
								break;
							}
						}
					}else {
						map[row]= -1;
						col++;
					}
				}else {
					row++;
					col = 0;
				}
			}else {
				if(col == n - 1) {
					if(row == 0) {
						break;
					}else {
						while(col >= n - 1) {
							row--;
							if(row < 0) {
								break;
							}
							col = map[row] + 1;
							map[row] = -1;
							if(col == n - 1) {
								break;
							}
						}
					}
					if(row < 0) {
						break;
					}
				}else {
					col++;
				}
			}
		}
		return result;
	}
	
	public static boolean isSatisfy2(int[]map, int col, int row, int n) {
		for(int i = 0;i < row;i++) {
			if(map[i] == col || (row - i) == Math.abs(map[i] - col)) {
				return false;
			}
		}
		return true;
	}
}