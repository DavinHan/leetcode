package com.test.easy;

public class CanWinNim {
	
	public static void main(String[] args) {
		System.out.println(new CanWinNim().canWinNim(4));		//false
		System.out.println(new CanWinNim().canWinNim(5));		//true
		System.out.println(new CanWinNim().canWinNim(47));		//true
	}

	/**
	 * @description 时间超出
	 */
	@Deprecated
	public boolean canWinNim1(int n) {
        return function(n, true);
	}

	public boolean function(int n, boolean isYou) {
		if(n <= 3) {
			return isYou;
		}else {
			if(isYou) {
				return function(n - 1, !isYou) || function(n - 2, !isYou) || function(n - 3, !isYou);
			}else {
				return function(n - 1, !isYou) && function(n - 2, !isYou) && function(n - 3, !isYou);
			}
		}
    }
	
	/**
	 * @description 巴什博弈：n % (m + 1) == 0时，先手的会赢
	 */
	public boolean canWinNim(int n) {
		return n % 4 != 0;
	}
}
