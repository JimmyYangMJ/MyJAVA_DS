package com.acm.test.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 * 递归实现
 * @author ymj
 * @Date： 2019/11/12 20:51
 */
public class InorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = null;
        a.right = new TreeNode(2);
        a.right.left = new TreeNode(3);
        List<Integer> list = new ArrayList<>();
        InorderTraversal inorderTraversal = new InorderTraversal();
        list = inorderTraversal.inorderTraversal(a);
        System.out.println(list);

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderRecur(root, list);
        return  list;
    }

    private void inOrderRecur(TreeNode node, List<Integer> list) {
        if (node == null) {
            return ;
        }
        inOrderRecur(node.left, list);
        list.add(node.val);
        inOrderRecur(node.right, list);

    }


}
