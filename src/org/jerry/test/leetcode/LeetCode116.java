package org.jerry.test.leetcode;

/**
 *
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * @author zhuqianchao
 * @date 22/9/2020 21:45
 */
public class LeetCode116 {

   private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        connectTwoNode(root.left, root.right);

        return root;
    }

    private void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        node1.next = node2;

        // 正常的同父节点左右相连
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);

        //  同级跨父节点
        connectTwoNode(node1.left, node2.left);
    }
}
