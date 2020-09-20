package test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 力扣589题
 * 前序遍历N叉树， 递归实现
 *
 * @author zhuqianchao
 * @date 20/9/2020 22:16
 */
public class LeetCode589 {


    List<Integer> a = new ArrayList<>();

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
