package org.jerry.test.algorithm;


/**
 * 判断一个链表是不是有环
 * <p>
 * 利用快慢指针
 *
 * @author zhuqianchao
 * @date 16/9/2020 21:41
 */
public class HasCycle {


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        Node head = new Node(-1);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        // 有环
//        n3.next = n1;

        System.out.println(new HasCycle().hasCycle(head));
    }


    public boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }

        // p是慢指针， q是快指针
        Node p = head, q = head;
        // p 走一步  q 走两步
        // 如果 p追上q那么肯定会有环， 不然永远追不到
        do {
            p = p.next;
            q = q.next;
            if (q == null) {
                return false;
            }
            q = q.next;
        } while (q != p && q != null);


        return q == p;


    }


    private static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }
}
