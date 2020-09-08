package com.acm.leecode.tree;

import com.acm.ds.show.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ymj
 * @Date： 2020/8/31 17:07
 * @description: 1161. 最大层内元素和
 */
public class Main1161 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /** 层序遍历 */
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        queue.offer(root);
        int count = 0;
        int max = root.val;
        int maxLevel = 1;
        int curLevel = 1;
        while (!queue.isEmpty()) {
            count = queue.size();
            int sum = 0;
            while (count-- > 0) {
                TreeNode treeNode = queue.poll();
                sum += treeNode.val;
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            if (sum > max) {
                max = sum;
                maxLevel = curLevel;
            }
            curLevel++;
        }
        return maxLevel;
    }
/********************递归实现的中序遍历************************/
    int n = 10000;
    int[] levelSum = new int[n];

    public void inorder(TreeNode node, int level) {
        if (node != null) {
            inorder(node.left, level + 1);
            levelSum[level] += node.val;
            inorder(node.right, level + 1);
        }
    }

    public int maxLevelSum2(TreeNode root) {
        inorder(root, 1);

        int maxIdx = 0;
        for (int i = 0; i < n; ++i)
            maxIdx = levelSum[i] > levelSum[maxIdx] ? i : maxIdx;
        return maxIdx;
    }

}
