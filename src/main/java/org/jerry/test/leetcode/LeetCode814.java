package org.jerry.test.leetcode;

/**
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 * <p>
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * <p>
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 * <p>
 * 示例1:
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 * <p>
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 *
 * @author zhuqianchao
 * @date 24/11/2020 20:38
 */
public class LeetCode814 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return (root.val == 0 && root.left == null && root.right == null) ? null : root;

    }

}
