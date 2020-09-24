package org.jerry.test.leetcode;

import java.util.StringJoiner;

/**
 * 翻转一棵二叉树。
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * 翻转二叉树
 *
 * @author zhuqianchao
 * @date 16/9/2020 19:53
 */
public class InvertTree {


    public static void main(String[] args) {
        // [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        TreeNode n = new TreeNode(2);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(9);

        root.left = n;

        root.right = n2;

        n.left = n3;

        n.right = n4;

        n2.left = n5;

        n2.right = n6;

        System.out.println(new InvertTree().invertTree(root));
    }


    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode t = new TreeNode(root.val);
        t.left = invertTree(root.right);

        t.right = invertTree(root.left);

        return t;
    }

    static class TreeNode {
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
}
