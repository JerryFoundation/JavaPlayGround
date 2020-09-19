package test.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS广度优先求左子树之和
 *
 * @author zhuqianchao
 * @date 19/9/2020 20:47
 */
public class SumOfLeftLeaves2 {


    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    ans += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                if (!isLeafNode(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

    private boolean isLeafNode(TreeNode node) {
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
