package test.algorithm;

/**
 * 循环队列
 *
 * @author zhuqianchao
 * @date 2020/8/24 22:25
 */
public class CircularQueue {

    private int head = 0, tail = 0;

    private int n;

    private int[] queue;


    public CircularQueue(int capacity) {
        queue = new int[capacity];
        n = capacity;
    }


    public void enqueue(int num) {
        // 判断队列是否已经满了 因为环形队列会浪费一个空间， 所以(tail + 1) % 数组长度， 如果和head相同，
        // 则证明队列已经放满了， 这样对于出队后再有入队时，head已经前移了， 队列又没有满了，可以继续插入数据，
        // 无需对数组进行搬迁操作
        if ((tail + 1) % n == head) {
            return;
        }
        queue[tail] = num;
        tail = (tail + 1) % n;
    }


    public int dequeue() {
        if (tail == head) {
            return -1;
        }
        int a = queue[head];
        head = (head + 1) % n;
        return a;
    }


    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(8);

        for (int i = 1; i <= 8; i++) {
            circularQueue.enqueue(i);
        }

        while (true) {
            int param = circularQueue.dequeue();
            if (param == -1) {
                break;
            }
            System.out.println(param);
        }


    }


}
