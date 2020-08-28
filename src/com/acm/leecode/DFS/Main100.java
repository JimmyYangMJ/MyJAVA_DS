package com.acm.leecode.DFS;

/**
 * 100.相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同
 * @author ymj
 * @Date： 2019/12/11 20:18
 */
public class Main100 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 方法递归
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null &&q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }else {
            if(p.val == q.val &&p.val == q.val){
                return isSameTree(p.left, q.left)
                        && isSameTree(p.right, q.right);
            }else{
                return false;
            }
        }
    }
    public static void main(String[] args) {
        Main100 main100 = new Main100();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);

        root2.left.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(4);


        System.out.println(main100.isSameTree(root,root2));

    }
}
