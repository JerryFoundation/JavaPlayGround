package org.jerry.test.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 例如：
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 10000
 *
 * @author zhuqianchao
 * @date 5/11/2020 22:15
 */
public class LeetCode104 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * DFS 实现
     *
     * @param root
     * @return int
     * @throws
     * @author zhuqianchao
     * @date 5/11/2020 22:16
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * BFS 实现
     *
     * @param root
     * @return int
     * @throws
     * @author zhuqianchao
     * @date 5/11/2020 22:17
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int n = queue.size();
            for (int i = 0; i < n; ++i) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
