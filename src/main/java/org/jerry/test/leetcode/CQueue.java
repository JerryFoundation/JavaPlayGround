package org.jerry.test.leetcode;

import java.util.LinkedList;
import java.util.StringJoiner;

/**
 * 用2个栈实现队列
 *
 * @author zhuqianchao
 * @date 2020/9/12 20:34
 */
public class CQueue {
    @Override
    public String toString() {
        return new StringJoiner(", ", CQueue.class.getSimpleName() + "[", "]")
                .add("inStack=" + inStack)
                .add("outStack=" + outStack)
                .toString();
    }

    LinkedList<Integer> inStack;
    LinkedList<Integer> outStack;

    public CQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void appendTail(int value) {
        inStack.addLast(value);
    }

    public int deleteHead() {

        if (!outStack.isEmpty()) {
            return outStack.removeLast();
        }
        if (inStack.isEmpty()) {
            return -1;
        }
        while (!inStack.isEmpty()) {
            outStack.addLast(inStack.removeLast());
        }

        return outStack.removeLast();
    }

    public static void main(String[] args) {
        CQueue queue = new CQueue();

        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);

        System.out.println(queue);


        System.out.println(queue.deleteHead());

        System.out.println(queue);


    }
}
