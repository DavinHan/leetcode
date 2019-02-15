package com.test;

import java.util.Scanner;

public class JewelsAndStones {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String J = scanner.next();
		String S = scanner.next();
		System.out.println(numJewelsInStones(J, S));
	}
	
	public static int numJewelsInStones(String J, String S) {
	      int count = 0;
			for(int i = 0;i < S.length();i++) {
				for(int k = 0;k < J.length();k++) {
					if(S.charAt(i) == J.charAt(k)) {
						count++;
						break;
					}
				}
			}
			return count;
	    }
}
