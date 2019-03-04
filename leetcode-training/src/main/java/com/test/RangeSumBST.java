package com.test;

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumBST {
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	
	public static void main(String[] args) {
		int[] r1 = new int[] {10,5,15,3,7,-1,18};
		int[] r2 = new int[] {10,5,15,3,7,13,18,1,-1,6};
		int L1 = 7,R1 = 15,L2 = 6,R2 = 10;
		TreeNode root1 = new TreeNode(10);
		root1.left = new TreeNode(5);
		root1.right = new TreeNode(15);
		root1.left.left = new TreeNode(3);
		root1.left.right = new TreeNode(7);
		root1.right.left = new TreeNode(18);
		
		TreeNode root2 = new TreeNode(10);
		root2.left = new TreeNode(5);
		root2.right = new TreeNode(15);
		root2.left.left = new TreeNode(3);
		root2.left.right = new TreeNode(7);
		root2.left.left.left = new TreeNode(1);
		root2.left.right.left = new TreeNode(6);
		root2.right.left = new TreeNode(13);
		root2.right.right = new TreeNode(18);
		
		System.out.println(rangeSumBST(root1, L1, R1));
		System.out.println(rangeSumBST(root2, L2, R2));
		
	}
	
	public static int rangeSumBST(TreeNode root, int L, int R) {
		Queue<TreeNode> q = new LinkedList<>();
		int sum = 0;
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode tmp = q.poll();
			if(tmp.left != null) {
				q.add(tmp.left);
			}
			if(tmp.right != null) {
				q.add(tmp.right);
			}
			if(tmp.val >= L && tmp.val <= R) {
				sum += tmp.val;
			}
		}
		return sum;
	}
}
