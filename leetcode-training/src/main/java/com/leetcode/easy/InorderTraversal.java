package com.leetcode.easy;

import java.util.*;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * @author yanhanf
 */
public class InorderTraversal {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> next = new Stack<>();
        next.push(root);
        boolean isFindLeft = true;
        while(!next.isEmpty()) {
            TreeNode p = next.peek();
            if(p.left == null) {
                p = next.pop();
                result.add(p.val);
                if(p.right != null) {
                    next.push(p.right);
                    isFindLeft = true;
                } else {
                    while (!next.isEmpty() && p.right == null) {
                        p = next.pop();
                        result.add(p.val);
                    }
                    if(p.right != null) {
                        next.push(p.right);
                        isFindLeft = true;
                    } else {
                        isFindLeft = false;
                    }
                }
            } else {
                if(isFindLeft) {
                    next.push(p.left);
                }
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    public void dfs(TreeNode p, List<Integer> result) {
          if(p == null) {
              return;
          }
          if(p.left != null) {
              dfs(p.left, result);
          }
          result.add(p.val);
          if(p.right != null) {
              dfs(p.right, result);
          }
    }

    public static void main(String[] args) {
        InorderTraversal i = new InorderTraversal();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println("target is [1,3,2], and test is " + i.inorderTraversal(root));
        System.out.println("target is [], and test is " + i.inorderTraversal(null));
        root = new TreeNode(1);
        System.out.println("target is [1], and test is " + i.inorderTraversal(root));
        root = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        System.out.println("target is [3,2,1], and test is " + i.inorderTraversal(root));
        root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        System.out.println("target is [1,2,3], and test is " + i.inorderTraversal(root));
        root = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        System.out.println("target is [1,3,2], and test is " + i.inorderTraversal(root));
        root = new TreeNode(3, new TreeNode(2), new TreeNode(4, new TreeNode(1), null));
        System.out.println("target is [2,3,1,4], and test is " + i.inorderTraversal(root));
    }
}
