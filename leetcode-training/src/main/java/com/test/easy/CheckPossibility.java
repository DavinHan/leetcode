package com.test.easy;

public class CheckPossibility {
	
	public static void main(String[] args) {
		int[] a = new int[] {4,2,3};		//true
		int[] b = new int[] {4,2,1};		//false
		int[] c = new int[] {3,4,2,3};		//false
		int[] d = new int[] {2,3,3,2,4};	//true
		int[] e = new int[] {1,3,2};		//true
		System.out.println(new CheckPossibility().checkPossibility(a));
		System.out.println(new CheckPossibility().checkPossibility(b));
		System.out.println(new CheckPossibility().checkPossibility(c));
		System.out.println(new CheckPossibility().checkPossibility(d));
		System.out.println(new CheckPossibility().checkPossibility(e));
	}
	
    public boolean checkPossibility(int[] nums) {
    	int len = nums.length - 1;
    	//first check
    	for(int i = 0;i < len;i++) {
    		if(nums[i] > nums[i + 1]) {
    			if(i + 1 != len) {
    				if(nums[i] > nums[i + 2]) {
    					nums[i] = nums[i + 1];
    				}else {
    					nums[i + 1] = nums[i];
    				}
    			}else {
    				nums[i + 1] = nums[i];
    			}
    			break;
    		}
    	}
    	//final settle
    	boolean finalSettle = true;
    	for(int i = 0;i < len;i++) {
    		if(nums[i] > nums[i + 1]) {
    			finalSettle = false;
    			break;
    		}
    	}
    	return finalSettle;
    }
}
