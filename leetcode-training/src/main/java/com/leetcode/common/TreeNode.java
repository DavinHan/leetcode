package com.leetcode.common;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * TreeNode
 *
 * @author yanhanf
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 层序输出
     * @return [层序输出]
     */
    @Override
    public String toString() {
        return this.val + (this.left == null && this.right == null ? "" : ","
                + (this.left == null ? "null" : left.toString()) + ","
                + (this.right == null ? "null" : right.toString()));
    }
}