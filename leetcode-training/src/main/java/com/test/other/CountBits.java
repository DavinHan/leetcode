package com.test.other;

public class CountBits {
	
	public static void main(String[] args) {
		StringBuilder s1 = new StringBuilder();
		for(int i : countBits2(16)) {
			s1.append(i).append(",");
		}
		System.out.println(s1.toString());
	}
	
	public static int[] countBits(int num) {
		int length = num + 1;
		int[] res = new int[length];
		for(int i = 1;i < length;i++) {
			String tmp = Integer.toBinaryString(i);
			for(int j = 0;j < tmp.length();j++) {
				if('1' == tmp.charAt(j)) {
					res[i] = res[i] + 1;
				}
			}
		}
		return res;
	}
	
	public static int[] countBits1(int num) {
		int size = num + 1;
		int[] res = new int[size];
		for(int i = 1;i < size;i++) {
			res[i] = count(i);
		}
		return res;
	}
	
	public static int count(int res) {
		if(res == 1 || res == 2) {
			return 1;
		}else {
			if(res % 2 == 0) {
				res = count(res >> 1);
			}else {
				res = count(res >> 1) + 1;
			}
		}
		return res;
	}
	
	public static int[] countBits2(int num) {
		int size = num + 1;
		int[] res = new int[size];
		for(int i = 1;i < size;i++) {
			if(i == 1 || i == 2) {
				res[i] = 1;
			}else {
				if(i % 2 == 0) {
					res[i] = res[i >> 1];
				}else {
					res[i] = res[i >> 1] + 1;
				}
			}
		}
		return res;
	}
}
