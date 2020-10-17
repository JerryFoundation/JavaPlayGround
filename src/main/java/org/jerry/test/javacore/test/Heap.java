package org.jerry.test.javacore.test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhuqianchao
 * @date 20/9/2020 22:48
 */
public class Heap {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.add(1);
        queue.add(2);
        queue.add(4);
        queue.add(3);

        System.out.println(queue.poll());
    }
}
