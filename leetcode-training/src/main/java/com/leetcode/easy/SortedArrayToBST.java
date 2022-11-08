package com.leetcode.easy;

import com.leetcode.common.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树
 *
 * @author yanhanf
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        TreeNode root = new TreeNode();
        sortArrayToBST(nums, 0, nums.length - 1, root);
        return root;
    }

    public void sortArrayToBST(int[] nums, int start, int end, TreeNode curr) {
        int i = (start + end) / 2;
        curr.val = nums[i];
        if (i - 1 >= start) {
            curr.left = new TreeNode();
            sortArrayToBST(nums, start, i - 1, curr.left);
        }
        if (i + 1 <= end) {
            curr.right = new TreeNode();
            sortArrayToBST(nums, i + 1, end, curr.right);
        }
    }

    public static void main(String[] args) {
        SortedArrayToBST s = new SortedArrayToBST();
        System.out.println("target is [0,-3,9,-10,null,5] 或 [0,-10,5,null,-3,null,9], and test is "
                + s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}).toString());
        System.out.println("target is [1,null,3] 或 [3,1], and test is " + s.sortedArrayToBST(new int[]{1, 3}));
    }

}
