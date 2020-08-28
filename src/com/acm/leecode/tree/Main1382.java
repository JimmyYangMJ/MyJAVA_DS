package com.acm.leecode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ymj
 * @Date： 2020/8/28 15:37
 * @description: 将二叉搜索树变平衡
 */
public class Main1382 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 参照 108
     * @param root
     * @return
     */
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inOrderRecur(root, list);
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return helper(nums, 0, nums.length - 1);

    }
    // 中序遍历 递归
    public  void inOrderRecur(TreeNode head, List list) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left, list);
        list.add(head.val);
        inOrderRecur(head.right, list);
    }


    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
