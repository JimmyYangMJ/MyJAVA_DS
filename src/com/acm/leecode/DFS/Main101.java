package com.acm.leecode.DFS;

/**
 * ������Ƿ��Ǿ���ԳƵ�
 * @author ymj
 * @Date�� 2019/12/11 19:24
 */
public class Main101 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * ���õݹ鷽���� �ݹ��жϣ�
     * root���������Ƿ��root �������� �Գ�
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }


    // ���� ����д���ж� ���������Ƿ����
    public boolean isSymmetric1(TreeNode root) {
        if(root == null){
            return true;
        }else{
            if (root.right == null && root.left == null){
                return true;
            }else if (root.right != null && root.left != null){
                if (root.right.val == root.left.val){
                    boolean left = isSymmetric(root.left);
                    boolean right = isSymmetric(root.right);
                    return  left&right;
                }else{
                    return false;
                }
            }else {
                return false;
            }
        }
    }
    public static void main(String[] args) {
        Main101 main101 = new Main101();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);


        System.out.println(main101.isSymmetric(root));

    }
}
