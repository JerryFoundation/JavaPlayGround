package org.jerry.test.leetcode;

/**
 * 判断一个树是不是另一个树的子树
 *
 * @author zhuqianchao
 * @date 2020/9/13 12:01
 */
public class SubStructure {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        treeNode.left = treeNode2;
        treeNode2.left = treeNode3;
        treeNode.right = treeNode4;


        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(3);

        treeNode5.left = treeNode6;


        System.out.println(new SubStructure().isSubStructure(treeNode, treeNode5));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) &&
                (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
