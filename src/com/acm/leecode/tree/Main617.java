package com.acm.leecode.tree;

/**
 * @author ymj
 * @Date： 2020/8/28 15:04
 * @description: 合并二叉树
 */
public class Main617 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 递归
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 1.合并当前节点
        // t1没有，而t2有的节点，直接返回t2
        if (t1 == null) {
            return t2;
        }
        // t1有，而t2没有的节点，t1不变，直接返回
        if (t2 == null) {
            return t1;
        }
        // t1和t2都有的节点，节点值相加，更新t1的值
        t1.val += t2.val;
        // 2.递归合并左子树和右子树
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }
}
