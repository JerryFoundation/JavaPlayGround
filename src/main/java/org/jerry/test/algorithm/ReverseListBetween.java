package org.jerry.test.algorithm;

import org.jerry.test.leetcode.AddTwoNumbers;

/**
 * @author zhuqianchao
 * @date 24/11/2020 21:38
 */
public class ReverseListBetween {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    /**
     * 后继节点
     */
    ListNode successor = null;

    public ListNode reverseListBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseListN(head, n);
        }
        head.next = reverseListBetween(head.next, m - 1, n - 1);
        return head;
    }

    private ListNode reverseListN(ListNode head, int n) {
        if (n == 1) {
            // 记录第n+1个节点
            successor = head.next;
            return head;
        }
        //以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseListN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }
}
