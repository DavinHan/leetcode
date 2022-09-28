package com.leetcode.easy;

import com.leetcode.common.TreeNode;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * @author yanhanf
 */
public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean isSame = (p == null && q == null) || (p != null && q != null && p.val == q.val);
        if(!isSame) {
            return false;
        }
        if(p == null) {
            return true;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public static void main(String[] args) {
        IsSameTree i = new IsSameTree();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        System.out.println("target is true, and test is " + i.isSameTree(p, q));
        p = new TreeNode(1);
        p.left = new TreeNode(2);
        q = new TreeNode(1);
        q.right = new TreeNode(2);
        System.out.println("target is false, and test is " + i.isSameTree(p, q));
        p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);
        q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);
        System.out.println("target is false, and test is " + i.isSameTree(p, q));
    }

}
