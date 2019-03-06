package com.test;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
	public static void main(String[] args) {
		int[] n = new int[] {1,2,3};
		System.out.println(1<<1);
		List<List<Integer>> res = subsets(n);
		for (List<Integer> list : res) {
			StringBuilder sb = new StringBuilder();
			for (int i : list) {
				sb.append(i);
			}
			System.out.println(sb.toString());
		}
	}
	
	@Deprecated
	public static List<List<Integer>> subsets1(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		int len = 0, length = nums.length;
		while(len <= length) {
			List<List<Integer>> list = new ArrayList<>();
			for(int i = 0;i < length;i++) {
				List<Integer> l = new ArrayList<>();
				for(int k = 0, j = 0;j < len;k++) {
					if(k == length) {
						k = 0;
					}
					if(!l.contains(nums[k])) {
						l.add(nums[k]);
						j++;
						if(list.contains(l)) {
							while(j != 0) {
								j--;
								l.remove(j);
							}
						}
					}
				}
				if(!list.contains(l)) {
					list.add(l);
				}else {
					continue;
				}
				if(list.get(0).size() == length) {
					break;
				}
			}
			res.addAll(list);
			len++;
		}
		return res;
	}
	
	/**
	 * @description 按位取数，{1，2，3} 只包含三个不同的值的情况，结果集中是除空集外包含7种情况，即：
	 * 001，010，100，011，101，110，111 ，我们记为集合A
	 * 即，每个位对应集合{1，2，3}中，组成的子集所取每个元素对应的位置
	 * 然后判断，每次取的元素对应的位置只要和集合{001，010，100}，记为集合B，分别进行与（&）操作
	 * 就能知道每次取元素对应集合B中哪一个元素
	 * 而001，010，100 即是 通过1进行左移0位、左移1位、左移2位得到的
	 * 只要集合A和集合B中的元素分别进行与操作不为0时，即可加入结果集
	 * @param nums
	 */
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());
		int length = nums.length;
		int sublen = (int) Math.pow(2, length);
		int hash = 1;
		while(hash < sublen){
			List<Integer> list = new ArrayList<>();
			for(int i = 0;i < length;i++) {
				int a = 1 << i;
				if((a&hash) != 0) {
					list.add(nums[i]);
				}
			}
			res.add(list);
			hash++;
		}
		return res;
	}
}