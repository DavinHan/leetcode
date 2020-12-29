package com.test.other;

public class FindComplement {
	
	public static void main(String[] args) {
		System.out.println(findComplement(4));
		System.out.println(findComplement(5));
		System.out.println(findComplement(1));
	}
	
	public static int findComplement(int num) {
		String res = "";
		while(num != 0) {
			if(num % 2 == 1) {
				res += 1;
			}else {
				res += 0;
			}
			num = num >> 1;
		}
		int len = res.length();
		for(int i = 0;i < len;i++) {
			if(res.charAt(i) == '0') {
				num = num + (int)Math.pow(2, i);
			}
		}
		return num;
	}
}
