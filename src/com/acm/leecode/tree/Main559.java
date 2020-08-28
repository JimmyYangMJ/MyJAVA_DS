package com.acm.leecode.tree;

import java.util.List;

/**
 * @author ymj
 * @Date： 2020/8/28 14:55
 * @description: N叉树的最大深度
 */
public class Main559 {


    class Node {
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
    };

    /**
     * 递归
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node node : root.children) {
            int height = maxDepth(node);
            if (max < height) {
                max = height;
            }
        }
        return max + 1;
    }
}
