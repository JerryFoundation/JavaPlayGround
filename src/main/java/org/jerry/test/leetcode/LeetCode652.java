package org.jerry.test.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 *
 *
 * @author zhuqianchao
 * @date 25/11/2020 20:42
 */
public class LeetCode652 {
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

    HashMap<String,Integer> memo = new HashMap<>();

    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        findTrees(root);
        return res;
    }

    private String findTrees(TreeNode treeNode) {
        if (treeNode == null) {
            return "#";
        }
        String left = findTrees(treeNode.left);

        String right = findTrees(treeNode.right);

        String subtree = left + "," + right + "," + treeNode.val;

        int finded = memo.getOrDefault(subtree, 0);
        if (finded == 1) {
            res.add(treeNode);
        }
        memo.put(subtree, finded + 1);
        return subtree;
    }
}
