package com.test;

import java.util.Stack;

public class MaxDepth {

	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(maxDepth(root));
	}
	
    public static int maxDepth(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	int left = 1, right = 1;
    	if(root.left != null) {
    		left = maxDepth(root.left) + 1;
    	}
    	if(root.right != null) {
    		right = maxDepth(root.right) + 1;
    	}
    	if(left > right) {
    		return left;
    	}else {
    		return right;
    	}
    }
}
