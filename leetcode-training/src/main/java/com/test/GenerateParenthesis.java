package com.test;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	
	public static void main(String[] args) {
		int n = 3;
		List<String> res = generateParenthesis(n);
		for(String result : res) {
			System.out.println(result);
		}
	}
	
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		int len = n * 2;
		return res;
	}
	
	public static List<String> function(String a, int len, List<String> res){
		if(len <= 2) {
			
			return null;
		}else {
			a = a + "(";
			len = len - 2;
		}
		return null;
	}
}
