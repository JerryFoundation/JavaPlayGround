package test.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 力扣589题
 * 前序遍历N叉树
 *
 * @author zhuqianchao
 * @date 20/9/2020 22:16
 */
public class LeetCode589 {


    List<Integer> a = new ArrayList<>();

    /**
     * 递归实现
     *
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @throws
     * @author zhuqianchao
     * @date 20/9/2020 22:26
     */
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return a;
        }
        a.add(root.val);
        for (Node r : root.children) {
            preorder(r);
        }
        return a;
    }


    /**
     * 迭代实现， 利用栈
     *
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @throws
     * @author zhuqianchao
     * @date 20/9/2020 22:26
     */
    public List<Integer> preorder2(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            stack.addAll(node.children);
        }
        return output;
    }


    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
