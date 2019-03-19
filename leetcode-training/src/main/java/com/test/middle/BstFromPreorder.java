package com.test.middle;

public class BstFromPreorder {
	
	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {8,5,1,7,10,12};
		TreeNode root = bstFromPreorder(a);
		System.out.println(root);
	}
	
    public static TreeNode bstFromPreorder(int[] preorder) {
    	int len = preorder.length;
    	TreeNode root = new TreeNode(preorder[0]);
    	for(int i = 1;i < len;i++) {
    		TreeNode tmp = root;
    		while(true) {
    			if(tmp.val > preorder[i]) {
    				if(tmp.left != null) {
    					tmp = tmp.left;
    				}else {
    					tmp.left = new TreeNode(preorder[i]);
    					break;
    				}
    			}else {
    				if(tmp.right != null) {
    					tmp = tmp.right;
    				}else {
    					tmp.right = new TreeNode(preorder[i]);
    					break;
    				}
    			}
    		}
    	}
    	return root;
    }
}
