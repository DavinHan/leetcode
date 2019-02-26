package com.test;

public class ToLowerCase {
	public static void main(String[] args) {
		String a = "Hello";
		String b = "here";
		String c = "LOVELY";
		System.out.println(toLowerCase(a));
		System.out.println(toLowerCase(b));
		System.out.println(toLowerCase(c));
	}
	
	public static String toLowerCase(String str) {
		char[] pow = str.toCharArray();
		StringBuilder result = new StringBuilder();
		for(int i=0;i<str.length();i++) {
			if(pow[i] > 64 && pow[i] < 90) {
				result.append((char)(pow[i] + 32));
			}else {
				result.append(pow[i]);
			}
		}
        return result.toString();
    }
}
