package com.test.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
	
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     boolean fl = false;
	     TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = null;
		List<Integer> list = postorderTraversal(root);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
	
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if(root == null) {
			return list;
		}
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		root.fl = true;
		while(!s.isEmpty()) {
			TreeNode tmp = s.peek();
			if(tmp.left != null && tmp.left.fl == false) {
				s.push(tmp.left);
				tmp.left.fl = true;
			}else {
				if(tmp.right != null && tmp.right.fl == false) {
					s.push(tmp.right);
					tmp.right.fl = true;
				}else {
					list.add(tmp.val);
					s.pop();
				}
			}
		}
		return list;
	}
}
