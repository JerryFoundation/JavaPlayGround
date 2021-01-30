package org.jerry.test.algorithm;

import java.util.StringJoiner;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 * @author zhuqianchao
 * @date 3/1/2021 22:16
 */


public class DeleteNode {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
                    .add("val=" + val)
                    .add("next=" + next)
                    .toString();
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(new DeleteNode().deleteNode(node1, 4));
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode f = head;
        ListNode t = head.next;

        while (t != null && t.val != val) {
            f = t;
            t = t.next;
        }

        if (t != null) {
            f.next = t.next;
        }
        return head;
    }

}
