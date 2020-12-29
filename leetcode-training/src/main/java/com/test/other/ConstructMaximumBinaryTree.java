package com.test.other;

public class ConstructMaximumBinaryTree {

	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {3,2,1,6,0,5};
		TreeNode root = constructMaximumBinaryTree(a);
	}
	
	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		TreeNode root = function(nums, 0, nums.length - 1);
		return root;
	}
	
	public static TreeNode function(int[] a, int left, int right) {
		if(left > right) {
			return null;
		}
		int max = 0, pos = 0;
		for(int i = left;i <= right;i++) {
			if(max <= a[i]) {
				max = a[i];
				pos = i;
			}
		}
		TreeNode tmp = new TreeNode(max);
		tmp.left = function(a, left, pos - 1);
		tmp.right = function(a, pos + 1, right);
		return tmp;
	}
}
