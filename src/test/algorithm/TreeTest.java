package test.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuqianchao
 * @date 2020/8/30 15:19
 */
public class TreeTest {

    public static void main(String[] args) {
        Node root = new Node();
        root.setVal(10);
        Node node1 = new Node();
        node1.setVal(20);
        Node node2 = new Node();

        node2.setVal(30);
        Node node3 = new Node();
        node3.setVal(40);
        Node node4 = new Node();
        node4.setVal(50);

        root.setLeft(node1);

        root.setRight(node2);

        node1.setLeft(node3);

        node2.setRight(node4);


        new TreeTest().preOrder(root);
        System.out.println();
        new TreeTest().midOrder(root);
        System.out.println();
        new TreeTest().tailOrder(root);

        System.out.println();

        System.out.println(new TreeTest().levelOrder(root));


    }


    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getVal());

        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void midOrder(Node root) {
        if (root == null) {
            return;
        }
        midOrder(root.getLeft());

        System.out.println(root.getVal());

        midOrder(root.getRight());
    }


    public void tailOrder(Node root) {
        if (root == null) {
            return;
        }
        tailOrder(root.getLeft());
        tailOrder(root.getRight());
        System.out.println(root.getVal());
    }


    public List<List<Integer>> levelOrder(Node root) {

        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();

        queue.add(root);

        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                Node node = queue.pop();
                temp.add(node.getVal());
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            res.add(temp);
        }

        return res;
    }


    private static class Node {
        private Integer val;

        private Node left;


        private Node right;

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
