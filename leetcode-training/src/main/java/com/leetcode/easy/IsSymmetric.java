package com.leetcode.easy;

import com.leetcode.common.TreeNode;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * @author yanhanf
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.right == null && root.left == null)) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if(l == null && r == null) {
            return true;
        }
        if(l != null && r != null && l.val == r.val) {
            return isSymmetric(l.right, r.left) && isSymmetric(l.left, r.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        IsSymmetric i = new IsSymmetric();
        System.out.println("target is true, and test is " + i.isSymmetric(TreeNode.buildTree(new Integer[]{1,2,2,3,4,4,3})));
        System.out.println("target is false, and test is " + i.isSymmetric(TreeNode.buildTree(new Integer[]{1,2,2,null,3,null,3})));
    }
}
