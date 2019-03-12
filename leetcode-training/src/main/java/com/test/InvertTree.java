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
	
	public static TreeNode invertTree(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		Deque<TreeNode> q = new LinkedList<>();
		s.push(root);
		TreeNode pos = root;
		TreeNode tmp = root;
		while(!s.isEmpty()) {
			while(!s.isEmpty()) {
				q.offer(s.pop());
			}
			if(q.size() > 1) {
				
			}else {
				
			}
		}
		return root;
	}
}
