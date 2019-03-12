package com.test;

import java.util.Stack;

public class MergeTrees {

	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t1.left = new TreeNode(3);
		t1.right = new TreeNode(2);
		t1.left.left = new TreeNode(5);
		t2.left = new TreeNode(1);
		t2.left.right = new TreeNode(4);
		t2.right = new TreeNode(3);
		t2.right.right = new TreeNode(7);
		TreeNode t = mergeTrees(t1, t2);
		System.out.println(t);
	}
	
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) {
			return null;
		}else if(t1 == null && t2 != null) {
			return t2;
		}else if(t1 != null && t2 == null) {
			return t1;
		}else {
			TreeNode t = new TreeNode(t1.val + t2.val);
			t.left = mergeTrees(t1.left, t2.left);
			t.right = mergeTrees(t1.right, t2.right);
			return t;
		}
	}
}
