package org.jerry.test.leetcode;

import java.util.*;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author zhuqianchao
 * @date 29/9/2020 22:22
 */
public class LeetCode145 {

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


    /**
     * 简单的递归
     *
     * @author zhuqianchao
     * @date 29/9/2020 22:23
     * @return
     * @throws
     */
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    /**
     * 迭代
     *
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @throws
     * @author zhuqianchao
     * @date 29/9/2020 22:24
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        if (null == root) return ans;
        stack.addFirst(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();
            ans.addFirst(node.val);
            if (null != node.left) {
                stack.addFirst(node.left);
            }
            if (null != node.right) {
                stack.addFirst(node.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t.right = t2;
        t2.left = t3;

        System.out.println(new LeetCode145().postorderTraversal3(t));

    }
}
