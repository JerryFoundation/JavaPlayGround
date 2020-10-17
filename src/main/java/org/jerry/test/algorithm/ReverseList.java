package org.jerry.test.algorithm;

import java.util.StringJoiner;

/**
 * @author zhuqianchao
 * @date 13/10/2020 21:51
 */
public class ReverseList {

    private static class ListNode {
        private int var;
        private ListNode next;

        public ListNode(int var) {
            this.var = var;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
                    .add("var=" + var)
                    .add("next=" + next)
                    .toString();
        }
    }


    public ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode newNode = reverseList(node.next);

        node.next.next = node;

        node.next = null;

        return newNode;
    }


    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode nxt = curr.next;
            // 翻转箭头
            curr.next = prev;
            //三人行
            prev = curr;
            //三人行
            curr = nxt;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;
        n4.next = null;

//        System.out.println(new ReverseList().reverseList(n1));
        System.out.println(new ReverseList().reverseList2(n1));
    }
}
