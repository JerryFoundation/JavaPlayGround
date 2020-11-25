package org.jerry.test.leetcode;

/**
 * @author zhuqianchao
 * @date 25/11/2020 21:11
 */
public class LeetCode230 {

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

    private int count = 0;

    private int res = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }
        kthSmallest(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
        }
        kthSmallest(root.right, k);
        return res;
    }

}
