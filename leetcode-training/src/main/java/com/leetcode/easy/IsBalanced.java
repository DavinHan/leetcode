package com.leetcode.easy;

import com.leetcode.common.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 *
 * @author yanhanf
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.right) - height(root.left)) <= 1
                    && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    public static void main(String[] args) {
        IsBalanced i = new IsBalanced();
        System.out.println("target is true, and test is " + i.isBalanced(TreeNode.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println("target is false, and test is " + i.isBalanced(TreeNode.buildTree(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
        System.out.println("target is true, and test is " + i.isBalanced(TreeNode.buildTree(new Integer[]{})));
        System.out.println("target is false, and test is " + i.isBalanced(TreeNode.buildTree(new Integer[]{1, 2, null, 3, 3, null, null, 4, 4})));
    }

}
