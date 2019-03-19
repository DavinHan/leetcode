package com.test.middle;

import java.util.Stack;

public class PruneTree {
	
	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		n1.left = null;
		n1.right = new TreeNode(0);
		n1.right.left = new TreeNode(0);
		n1.right.right = new TreeNode(1);
		TreeNode r1 = pruneTree1(n1);
		System.out.println(r1);
		//1,0,1,0,0,0,1
		TreeNode n2 = new TreeNode(1);
		n2.left = new TreeNode(0);
		n2.right = new TreeNode(1);
		n2.left.left = new TreeNode(0);
		n2.left.right = new TreeNode(0);
		n2.right.left = new TreeNode(0);
		n2.right.right = new TreeNode(1);
		TreeNode r2 = pruneTree1(n2);
		System.out.println(r2);
		//1,1,0,1,1,0,1,0
		TreeNode n3 = new TreeNode(1);
		n3.left = new TreeNode(1);
		n3.right = new TreeNode(0);
		n3.left.left = new TreeNode(1);
		n3.left.right = new TreeNode(1);
		n3.right.left = new TreeNode(0);
		n3.right.right = new TreeNode(1);
		n3.left.left.left = new TreeNode(0);
		TreeNode r3 = pruneTree1(n3);
		System.out.println(r3);
		//0
		TreeNode n4 = new TreeNode(0);
		TreeNode r4 = pruneTree1(n4);
		System.out.println(r4);
	}
	
    public static TreeNode pruneTree(TreeNode root) {
    	if(root == null) {
    		return null;
    	}
    	Stack<TreeNode> s = new Stack<>();
        s.push(root);
    	while(!s.isEmpty()) {
    		TreeNode node = s.pop();
    		if(isDel(node.left)) {
    			node.left = null;
    		}else {
    			s.push(node.left);
    		}
    		if(isDel(node.right)) {
    			node.right = null;
    		}else {
    			s.push(node.right);
    		}
    	}
    	return root;
    }
    
    public static boolean isDel(TreeNode root) {
    	if(root == null) {
    		return true;
    	}else {
    		if(root.val == 1) {
    			return false;
    		}else {
    			return isDel(root.left) && isDel(root.right);
    		}
    	}
    }
    
    /**
     * @description 后序遍历
     */
    public static TreeNode pruneTree1(TreeNode root) {
    	if(root == null) {
    		return null;
    	}else {
    		root.left = pruneTree1(root.left);
    		root.right = pruneTree1(root.right);
    		if(root.left == null && root.right == null && root.val == 0) {
    			return null;
    		}
    	}
    	return root;
    }
}
