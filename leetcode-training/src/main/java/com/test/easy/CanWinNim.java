package com.test.easy;

public class CanWinNim {
	
	public static void main(String[] args) {
		System.out.println(new CanWinNim().canWinNim2(5));
	}

	/**
	 * @description 堆栈溢出
	 */
	@Deprecated
	public boolean canWinNim1(int n) {
        return function(n, true);
	}

	public boolean function(int n, boolean isYou) {
		if(n <= 3) {
			return isYou;
		}else {
			return function(n - 1, !isYou) && function(n - 2, !isYou) && function(n - 3, !isYou);
		}
    }
	
	/**
	 * @description 堆栈溢出
	 */
	@Deprecated
	public boolean canWinNim2(int n) {
		boolean isYou = true;
		if(n <= 3) {
			return isYou;
		}
		Boolean[] win = new Boolean[n];
		win[0] = isYou;
		win[1] = isYou;
		win[2] = isYou;
		isYou = false;
		for(int i = 3;i < n;i++) {
			win[i] = win[i - 1] && win[i - 2] && win[i - 3] && isYou;
			if(isYou == true) {
				isYou = false;
			}else {
				isYou = true;
			}
		}
		return win[n - 1];
	}
	
	public boolean canWinNim(int n) {
		
		return true;
	}
}
