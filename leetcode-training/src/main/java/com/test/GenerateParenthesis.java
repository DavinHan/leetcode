package com.test;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	
	public static void main(String[] args) {
		int n = 1;
		List<String> res = generateParenthesis1(n);
		for(String result : res) {
			System.out.println(result);
		}
	}
	
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		function(res, n);
		return res;
	}
	
	public static void function(List<String> res, int n){
		if(res.size() == 0) {
			String tmp = "(";
			res.add(tmp);
			function(res, n);
		}else {
			for(int i = 0;i < res.size();i++) {
				String tmp = res.remove(i);
				int l = 0,r = 0, len = 0;
				for(int j = 0;j < tmp.length();j++) {
					if(tmp.charAt(j) == '(') {
						l++;
						len++;
					}else {
						r++;
						len--;
					}
				}
				if(len < 0) {
					continue;
				}

				if(l < n) {
					res.add(tmp+"(");
					function(res,n);
				}
				if(r < n) {
					res.add(tmp + ")");
					function(res, n);
				}
				
				if(l == n && r == n) {
					res.add(i, tmp);
				}
			}
		}
	}
	
	/**
	 * @description 此方法只需几ms即可，而上面的方式需要1000+ms
	 * @param n
	 */
	public static List<String> generateParenthesis1(int n) {
		String str = "";
		List<String> res = new ArrayList<>();
		function1(res, str, 0, 0, n);
		return res;
	}
	
	/**
	 * @param res 最终结果集
	 * @param str 用于递归传递的参数，作为拼接字符串使用
	 * @param l 左括号数量
	 * @param r 右括号数量
	 * @param n 括号对的数量
	 */
	public static void function1(List<String> res, String str, int l, int r, int n) {
		if(l > n || r > n) {
			return;
		}
		
		if(l == n && r == n) {
			res.add(str);
		}
		
		if(l >= r) {
			function1(res, str + "(", l + 1, r, n);
			function1(res, str + ")", l, r + 1, n);
		}
	}
}
