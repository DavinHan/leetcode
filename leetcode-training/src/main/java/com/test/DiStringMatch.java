package com.test;

public class DiStringMatch {
	public static void main(String[] args) {
		String a = "IDID";
		String b = "III";
		String c = "DDI";
		System.out.println(diStringMatch(a));
		System.out.println(diStringMatch(b));
		System.out.println(diStringMatch(c));
	}
	
	public static int[] diStringMatch(String S) {
        int length = S.length();
		int[]a = new int[length + 1];
		int[]b = new int[length + 1];
        for(int i = 0;i <= length;i++) {
        	a[i] = i;
        }
        int i = 0,j = 0,k = 0;
        for(;k < length;k++) {
        	if(S.charAt(k) == 'D') {
        		b[k] = a[length - i];
        		a[length - i] = -1;
        		i++;
        	}else {
        		b[k] = a[j];
        		a[j] = -1;
        		j++;
        	}
        }
        for(int p = 0;p <= length;p++) {
        	if(a[p] != -1) {
        		b[k] = a[p];
        		break;
        	}
        }
		return b;
    }
}
