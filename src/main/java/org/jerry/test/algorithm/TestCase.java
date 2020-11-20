package org.jerry.test.algorithm;

import java.util.StringJoiner;

/**
 * @author zhuqianchao
 * @date 19/11/2020 15:04
 */
public class TestCase {

    private static class Node {
        private int var;
        private Node next;

        Node(int var) {
            this.var = var;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                    .add("var=" + var).add("next=" + next)
                    .toString();
        }
    }


    public Node testCase(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node newNode = testCase(node.next);
        node.next.next = node;
        node.next = null;
        return newNode;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        Node n3 = new Node(3);
        n2.next = n3;
        System.out.println(new TestCase().testCase(n1));
    }
}
