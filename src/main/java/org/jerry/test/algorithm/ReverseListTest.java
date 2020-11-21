package org.jerry.test.algorithm;

import java.util.StringJoiner;

/**
 * @author zhuqianchao
 * @date 20/11/2020 23:58
 */
public class ReverseListTest {
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
        ListNode pre = null;
        ListNode curr = node;

        // 为null就遍历完了
        while (curr != null) {
            ListNode nxt = curr.next;
            // 调换连表指向
            curr.next = pre;

            // 把当前已经遍历的节点 置为前置节点
            pre = curr;

            // 把上面已经获取的下一次要遍历的节点 置为当前节点准备下一次循环遍历
            curr = nxt;
        }

        return pre;
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

        System.out.println(new ReverseListTest().reverseList(n1));
    }
}
