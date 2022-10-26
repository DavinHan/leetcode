package com.leetcode.common;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 1,2,2,3,4,4,3
     */
    public static TreeNode buildTree(Integer[] nodes) {
        TreeNode root = new TreeNode();
        if(nodes.length > 0) {
            root.val = nodes[0];
        }
        List<TreeNode> l = new ArrayList<>();;
        l.add(root);
        int curr = 0;
        for (int i = 1;i < nodes.length;i += 2) {
            TreeNode p = l.get(curr++);
            if(p == null) {
                break;
            }
            if(nodes[i] != null) {
                p.left = new TreeNode();
                p.left.val = nodes[i];
                l.add(p.left);
            }
            if(i + 1 < nodes.length && nodes[i + 1] != null) {
                p.right = new TreeNode();
                p.right.val = nodes[i + 1];
                l.add(p.right);
            }
        }
        return root;
    }
}