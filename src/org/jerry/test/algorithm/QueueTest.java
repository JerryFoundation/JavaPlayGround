package org.jerry.test.algorithm;

/**
 * @author zhuqianchao
 * @date 2020/8/23 23:10
 */
public class QueueTest {
    private String[] queue;

    private int n;

    private int head;

    private int tail;


    public QueueTest(int capacity) {
        this.queue = new String[capacity];
        this.n = capacity;
    }

    public void enqueue(String value) {
        if (head == n) {
            if (head == 0) {
                return;
            }
            if (tail - head >= 0)
                System.arraycopy(queue, head, queue, 0, tail - head);
            tail -= head;
            head = 0;
        }
        queue[tail] = value;
        ++tail;
    }

    public String dequeue() {
        if (tail == head) {
            return null;
        }
        String value = queue[head];
        ++head;
        return value;
    }


    public static void main(String[] args) {
        QueueTest queueTest = new QueueTest(10);
        for (int i = 0; i < 10; i++) {
            queueTest.enqueue(i + "");
        }
        while (true) {
            String value = queueTest.dequeue();
            if (value == null) {
                break;
            }
            System.out.println(value);
        }


    }
}
