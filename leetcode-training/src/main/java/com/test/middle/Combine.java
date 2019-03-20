package com.test.middle;

import java.util.ArrayList;
import java.util.List;

public class Combine {
	
	public static void main(String[] args) {
		Combine c = new Combine();
		List<List<Integer>> res = c.combine(4, 2);
		for(int i = 0;i < res.size();i++) {
			String tmp = "";
			for(int j = 0;j < res.get(i).size();j++) {
				tmp = tmp + res.get(i).get(j) + ",";
			}
			System.out.println(tmp);
		}
	}
	
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		
		return res;
	}
	
	public List<List<Integer>> function(int n, int k,List<List<Integer>> list){
		
		return null;
	}
}
