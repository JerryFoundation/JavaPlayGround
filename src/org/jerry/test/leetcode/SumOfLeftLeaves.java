package org.jerry.test.leetcode;

/**
 * 求左子树之和
 *
 * @author zhuqianchao
 * @date 19/9/2020 20:33
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        // 如果是空节点返回0
        return root != null ? dfs(root) : 0;
    }

    /**
     * 深度优先
     * @author zhuqianchao
     * @date 19/9/2020 20:43
     */
    public int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            // 判断左节点是不是叶子节点了， 不是就继续递归
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            // 右节点不为空， 并且这个右节点不是叶子节点， 就加入递归
            ans += dfs(node.right);
        }
        return ans;
    }

    /**
     * 判断节点是否是叶子节点
     * @author zhuqianchao
     * @date 19/9/2020 20:45
     */
    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
