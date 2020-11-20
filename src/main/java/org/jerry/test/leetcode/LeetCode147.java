package org.jerry.test.leetcode;

import java.util.StringJoiner;

/**
 * 链表插入排序
 *
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @author zhuqianchao
 * @date 20/11/2020 20:22
 */
public class LeetCode147 {
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
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(44);
        l2.next = l3;
        ListNode l4 = new ListNode(11);
        l3.next = l4;
        System.out.println(new LeetCode147().insertionSortList(l1));
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 哑结点
        ListNode dummyHead = new ListNode(0);
        // 哑结点的下一个指向这个链表
        // 0 -- 3 -- 2 -- 44 -- 11
        dummyHead.next = head;
        // 末尾节点  3
        ListNode lastSorted = head,
                // 当前比对节点，  2
                curr = head.next;
        // 比对节点不为空
        while (curr != null) {
            // 如果末尾节点的值 比 当前比对节点要小， 或者等于
            if (lastSorted.val <= curr.val) {
                // 末尾节点向右移动一位
                lastSorted = lastSorted.next;
            } else {
                // 否则 把哑结点赋值给 前置节点
                ListNode prev = dummyHead;
                // 一直从前置节点遍历， 直到前置节点比当前节点大
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                // 当前节点的下一个 节点 赋值个 末尾节点的下一个节点
                lastSorted.next = curr.next;
                // 前置节点的下一个 赋值的 当前节点的下一个
                curr.next = prev.next;
                // 当前节点 赋值给前置节点的下一个， 也就是找到了位置
                prev.next = curr;
            }
            // 继续移动当前比对节点
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}
