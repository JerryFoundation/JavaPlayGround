package org.jerry.test.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 反向输出链表值
 *
 * @author zhuqianchao
 * @date 2020/9/12 20:10
 */
public class ReversePrint {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;

        System.out.println(Arrays.toString(new ReversePrint().reversePrint(node1)));

    }

    public int[] reversePrint(ListNode head) {

        LinkedList<Integer> stack = new LinkedList<>();

        ListNode node = head;
        while (node != null) {
            stack.addLast(node.val);
            node = node.next;
        }
        int[] re = new int[stack.size()];
        for (int i = 0; i < re.length; ++i) {
            re[i] = stack.removeLast();
        }

        return re;

    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
