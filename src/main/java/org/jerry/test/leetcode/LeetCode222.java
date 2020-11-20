package org.jerry.test.leetcode;

import java.util.StringJoiner;

/**
 * 给出一个完全二叉树，求出该树的节点个数。
 * <p>
 * 说明：
 * <p>
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * 输出: 6
 *
 * @author zhuqianchao
 * @date 20/11/2020 21:14
 */
public class LeetCode222 {

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

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode.left = treeNode2;
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        treeNode2.left = treeNode4;
        TreeNode treeNode5 = new TreeNode(5);
        treeNode2.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(6);
        treeNode3.left = treeNode6;

        System.out.println(new LeetCode222().countNodes2(treeNode));
    }

    private volatile int count = 0;

    public int countNodes(TreeNode root) {
        dfs(root);
        return count;
    }


    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        count++;
    }

    public int countNodes2(TreeNode root) {
        return root == null ? 0 : 1 + countNodes2(root.left) + countNodes2(root.right);
    }
}
