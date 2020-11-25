package org.jerry.test.leetcode;

import java.util.StringJoiner;

/**
 * @author zhuqianchao
 * @date 25/11/2020 21:40
 */
public class LeetCode700 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", TreeNode.class.getSimpleName() + "[", "]")
                    .add("val=" + val)
                    .add("left=" + left)
                    .add("right=" + right)
                    .toString();
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null && val != root.val) {
            root = (val < root.val) ? root.left : root.right;
        }
        return root;
    }
}
