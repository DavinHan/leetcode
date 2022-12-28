package com.leetcode.easy;

import com.leetcode.common.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 * <br/>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <br/>
 * 说明：叶子节点是指没有子节点的节点。
 *
 * @author yanhanf
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return height(root);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right != null) {
            return height(root.right) + 1;
        } else if (root.left != null && root.right == null) {
            return height(root.left) + 1;
        } else {
            return Math.min(height(root.left), height(root.right)) + 1;
        }
    }

    public static void main(String[] args) {
        MinDepth m = new MinDepth();
        // "输入：root = [3,9,20,null,null,15,7] 输出：2"
        System.out.println("target is 2, and test is "
                + m.minDepth(TreeNode.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        // "输入：root = [2,null,3,null,4,null,5,null,6] 输出：5"
        System.out.println("target is 5, and test is "
                + m.minDepth(TreeNode.buildTree(new Integer[]{2, null, 3, null, 4, null, 5, null, 6})));
    }

}
