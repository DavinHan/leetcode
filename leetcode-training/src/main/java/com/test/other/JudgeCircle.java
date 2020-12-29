package com.test.other;

public class JudgeCircle {

	public static void main(String[] args) {
		System.out.println(judgeCircle("UD"));
		System.out.println(judgeCircle("LL"));
	}
	
	/**
	 * @description 记录坐标值为（x,y）左右移动加减x值,上下移动加减y值.(x,y)为(0,0)时表示回到原点
	 * @param moves
	 * @return
	 */
	public static boolean judgeCircle(String moves) {
		int x = 0, y = 0;
		int len = moves.length();
		for(int i = 0;i < len;i++) {
			switch (moves.charAt(i)) {
			case 'R':
				x++;
				break;
			case 'L':
				x--;
				break;
			case 'U':
				y++;
				break;
			case 'D':
				y--;
				break;
			}
		}
		if(x == 0 && y == 0) {
			return true;
		}else {
			return false;
		}
	}
}
