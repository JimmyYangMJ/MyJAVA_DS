package com.acm.leecode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ymj
 * @Date： 2020/8/27 17:06
 * @description: N 叉树的前序遍历
 */
public class Main589 {
    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static List<Integer> list = new LinkedList<>();

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        for (Node node: root.children) {
            preorder(node);
        }
        return list;
    }
    /**
     * 非递归 可以使用 队列/堆栈实现
     */

}
