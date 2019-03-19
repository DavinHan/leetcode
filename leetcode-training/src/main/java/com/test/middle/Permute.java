package com.test.middle;

import java.util.ArrayList;
import java.util.List;

public class Permute {
	
	public static void main(String[] args) {
		Permute permute = new Permute();
		int[] a = new int[] {1,2,3};
		List<List<Integer>> res = permute.permute(a);
		for(int i = 0;i < res.size();i++) {
			String tmp = "";
			for(int j = 0;j < res.get(i).size();j++) {
				tmp = tmp + res.get(i).get(j) + ",";
			}
			System.out.println(tmp);
		}
	}
	
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	for(int i = 0;i < nums.length;i++) {
        	List<Integer> tmp = new ArrayList<>();
    		tmp.add(nums[i]);
    		res.add(tmp);
    	}
    	return function(res, nums);
    }
    
    public List<List<Integer>> function(List<List<Integer>> res, int[] nums) {
    	if(res.get(0).size() == nums.length) {
    		return res;
    	}
    	List<List<Integer>> result = new ArrayList<>();
    	for(List<Integer> list : res) {
    		for(int i = 0;i < nums.length;i++) {
    			if(!list.contains(nums[i])) {
    				List<Integer> l = new ArrayList<>();
    				l.addAll(list);
    				l.add(nums[i]);
    				result.add(l);
    			}
    		}
    	}
    	return function(result, nums);
    }
}
