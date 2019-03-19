package com.test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class InvertTree {
	
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		TreeNode res = invertTree(root);
		System.out.println(res);
	}
	
	/**
	 * @description 每个节点的左右节点交换，依次递归
	 */
	public static TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		if(root.left != null && root.right != null) {
			TreeNode left = root.left;
			TreeNode right = root.right;
			root.left = invertTree(right);
			root.right = invertTree(left);
		}else if(root.left != null && root.right == null) {
			root.right = invertTree(root.left);
			root.left = null;
		}else if(root.left == null && root.right != null) {
			root.left = invertTree(root.right);
			root.right = null;
		}
		return root;
	}
	
	public static TreeNode invertTree1(TreeNode root) {
		if(root == null) {
			return null;
		}else {
			TreeNode left = root.left;
			root.left = invertTree1(root.right);
			root.right = invertTree1(left);
			return root;
		}
	}
}
