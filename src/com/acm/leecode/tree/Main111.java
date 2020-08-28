package com.acm.leecode.tree;

/**
 * @author ymj
 * @Date： 2020/8/28 15:55
 * @description: 二叉树的最小深度
 */
public class Main111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int right = minDepth(root.right);
        int left = minDepth(root.left);
        if(right == 0) {
            return left + 1;
        }else if (left == 0) {
            return right + 1;
        }
        return right < left ? right + 1 : left + 1;
    }
}
