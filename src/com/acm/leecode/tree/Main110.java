package com.acm.leecode.tree;

/**
 * @author ymj
 * @Date： 2020/8/27 16:48
 * @description: 平衡二叉树
 */
public class Main110 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // 递归调用
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1
                    && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = height(root.left);
            int right = height(root.right);
            return  left > right ? left+1 : right+1;
        }
    }
}

