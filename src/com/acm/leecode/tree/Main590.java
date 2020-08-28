package com.acm.leecode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ymj
 * @Date： 2020/8/27 17:31
 * @description: N叉树的后序遍历
 */
public class Main590 {
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


    List<Integer> list = new ArrayList<>();
    /**
     * 递归
     */
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return list;
        }
        for (Node node : root.children) {
            postorder(node);
        }
        list.add(root.val);
        return list;
    }
}
