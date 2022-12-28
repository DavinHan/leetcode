package com.leetcode.easy;

import com.leetcode.common.TreeNode;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 *
 * @author yanhanf
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        return targetSum == countPathSum(root, targetSum, root.val);
    }

    public int countPathSum(TreeNode r, int targetSum, int tmp) {
        int t = tmp;
        if(r.right == null && r.left == null && t == targetSum) {
            return t;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        HasPathSum h = new HasPathSum();
        System.out.println("target is true, and test is "
                + h.hasPathSum(TreeNode.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 22));
        System.out.println("target is false, and test is " + h.hasPathSum(TreeNode.buildTree(new Integer[]{1, 2, 3}), 5));
        System.out.println("target is false, and test is " + h.hasPathSum(TreeNode.buildTree(new Integer[]{}), 0));
    }
}
