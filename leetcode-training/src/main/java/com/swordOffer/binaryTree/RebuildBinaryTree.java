package com.swordOffer.binaryTree;

/**
 * REQUIREMENTS:
 * The binary tree is reconstructed through the pre-order traversal and the mid-order traversal array of the binary tree.
 */
public class RebuildBinaryTree {

    private int[] preArray;
    private int[] midArray;
    private TreeNode root;

    public TreeNode rebuildTree(int[] preArray, int[] midArray){
        if(preArray.length == 0 || midArray.length == 0) {
            return null;
        }
        this.preArray = preArray;
        this.midArray = midArray;
        this.root =  rebuildChildTree(0, preArray.length, 0, midArray.length);
        return root;
    }

    public TreeNode rebuildChildTree(int preStart, int preEnd, int midStart, int midEnd) {
        if(preStart >= preEnd || midStart >= midEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preArray[preStart]);
        int midRootPos = midStart;
        while(midRootPos <= midEnd && midArray[midRootPos] != preArray[preStart]) {
            midRootPos++;
        }
        int midPosLen = midRootPos - midStart;
        if(midRootPos > midStart) {
            root.l = rebuildChildTree(preStart + 1, preStart + midPosLen + 1, midStart, midRootPos);
        } else {
            root.l = null;
        }
        if(midRootPos - midStart < preEnd - preStart) {
            root.r = rebuildChildTree(preStart + midPosLen + 1, preEnd, midRootPos + 1, midEnd);
        } else {
            root.r = null;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] mid = new int[]{4,7,2,1,5,3,8,6};
        RebuildBinaryTree t = new RebuildBinaryTree();
        TreeNode root = t.rebuildTree(pre, mid);
        System.out.println(root.toString());
        // expect result : 1,2,4,null,7,null,null,null,3,5,null,null,6,8,null,null,null,
    }
}

class TreeNode{
    public int val;
    public TreeNode l;
    public TreeNode r;
    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val + "," + (l == null ? "null,": l.toString()) + (r == null ? "null," : r.toString());
    }
}
