package com.test.easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

	public static void main(String[] args) {
		SelfDividingNumbers s = new SelfDividingNumbers();
		List<Integer> res = s.selfDividingNumbers(1, 22);
		String tmp = "";
		for(Integer i : res) {
			tmp = tmp + i + ",";
		}
		System.out.println(tmp);
	}
	
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> res = new ArrayList<>();
		boolean isOK = false;
		for(int i = left;i <= right;i++) {
			String tmp = Integer.toString(i);
			for(int j = 0;j < tmp.length();j++) {
				int k = Integer.parseInt(tmp.charAt(j) + "");
				if(k == 0) {
					isOK = false;
					break;
				}
				if(i % k != 0) {
					isOK = false;
					break;
				}else {
					isOK = true;
				}
			}
			if(isOK == true) {
				res.add(i);
			}
		}
		return res;
	}
}
