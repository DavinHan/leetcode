package com.test;

public class HammingDistance {

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
	}
	
    public static int hammingDistance(int x, int y) {
    	String xx = Integer.toBinaryString(x);
    	String yy = Integer.toBinaryString(y);
    	int count = 0, i = 0;
    	int len = x < y ? xx.length() : yy.length();
    	for(;i < len;i++) {
    		if(xx.charAt(xx.length() - i - 1) != yy.charAt(yy.length() - i - 1)) {
    			count++;
    		}
    	}
    	if(x > y) {
    		for(;i < xx.length();i++) {
    			if(xx.charAt(xx.length() - i - 1) == '1') {
    				count++;
    			}
    		}
    	}else {
    		for(;i < yy.length();i++) {
    			if(yy.charAt(yy.length() - i - 1) == '1') {
    				count++;
    			}
    		}
    	}
    	return count;
    }
    
    /**
     * @description 该方法和上述方法的时间空间花费一致
     */
    public static int hammingDistance2(int x,int y) {
    	return Integer.bitCount(x^y);
    }
}
