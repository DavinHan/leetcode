package com.test.middle;

import java.util.ArrayList;
import java.util.List;

public class Combine {
	
	public static void main(String[] args) {
		Combine c = new Combine();
		List<List<Integer>> res = c.combine(20, 16);
		for(int i = 0;i < res.size();i++) {
			String tmp = "";
			for(int j = 0;j < res.get(i).size();j++) {
				tmp = tmp + res.get(i).get(j) + ",";
			}
			System.out.println(tmp);
		}
	}
	
	//TODO 未完成超时测试
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		for(int i = 1;i <= n;i++) {
			List<Integer> list = new ArrayList<>();
			list.add(i);
			res.add(list);
		}
		if(!res.isEmpty()) {
			while(res.get(0).size() < k) {
				List<Integer> l = res.remove(0);
				for(int i = l.get(l.size() - 1) + 1;i <= n;i++) {
					if(!l.contains(i)) {
						List<Integer> tmp = new ArrayList<>();
						tmp.addAll(l);
						tmp.add(i);
						if(!res.contains(tmp)) {
							res.add(tmp);
						}
					}
				}
			}
		}
		return res;
	}
}
