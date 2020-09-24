package org.jerry.test.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhuqianchao
 * @date 2020/9/6 21:36
 */
public class LevelOrderBottom {

    static class TreeNode {
        private int val;

        private TreeNode left;

        private TreeNode right;

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    level.add(node.val);
                    TreeNode left = node.left, right = node.right;
                    if (left != null) {
                        queue.offer(left);
                    }
                    if (right != null) {
                        queue.offer(right);
                    }
                }
            }
            levelOrder.add(0, level);
        }
        return levelOrder;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        TreeNode treeNode2 = new TreeNode();
        TreeNode treeNode3 = new TreeNode();
        treeNode.val = 3;
        treeNode2.val = 4;
        treeNode3.val = 5;

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;


        System.out.println(new LevelOrderBottom().levelOrderBottom(treeNode));
    }
}
