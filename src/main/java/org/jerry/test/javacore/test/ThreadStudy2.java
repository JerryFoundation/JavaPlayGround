package org.jerry.test.javacore.test;

import java.util.Random;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Math.random;

/**
 * @author zhuqianchao
 * @date 28/9/2020 21:18
 */
public class ThreadStudy2 {

   static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) {
        AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<>("a",0);
//        Queue queue = new Queue();
//        new Thread(new Producer(queue)).start();
//        new Thread(new Producer(queue)).start();
//        new Thread(new Consumer(queue)).start();


        System.out.println(atomicStampedReference.compareAndSet("a", "b", 1, 1));

        System.out.println(atomicStampedReference.getReference() + " " + atomicStampedReference.getStamp());


    }

    static class Producer implements Runnable {

        Queue queue;

        Producer(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10000; i++) {
                    doingLongTime();
                    queue.putEle(new Random().nextInt(1000));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

    private static void doingLongTime() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Consumer implements Runnable {

        Queue queue;

        Consumer(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10000; i++) {
                    doingLongTime();
                    queue.takeEle();
                    longAdder.increment();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    static class Queue {
        Lock lock = new ReentrantLock();
        Condition prodCond  = lock.newCondition();
        Condition consCond = lock.newCondition();

        final int CAPACITY = 10;
        Object[] container = new Object[CAPACITY];
        int count = 0;
        int putIndex = 0;
        int takeIndex = 0;

        public void putEle(Object ele) throws InterruptedException {
            try {
                lock.lock();
                while (count == CAPACITY) {
                    System.out.printf("队列已满：%d，生产者开始睡大觉。。。", count);
                    prodCond.await();
                }
                container[putIndex] = ele;
                System.out.printf("生产元素：%d", ele);
                putIndex++;
                if (putIndex >= CAPACITY) {
                    putIndex = 0;
                }
                count++;
                
                System.out.printf("通知消费者去消费。。。");
                consCond.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public Object takeEle() throws InterruptedException {
            try {
                lock.lock();
                while (count == 0) {
                    System.out.printf("队列已空：%d，消费者开始睡大觉。。。", count);
                    consCond.await();
                }
                Object ele = container[takeIndex];
                System.out.printf("消费元素：%d", ele);
                takeIndex++;
                if (takeIndex >= CAPACITY) {
                    takeIndex = 0;
                }
                count--;
                System.out.printf("通知生产者去生产。。。");
                prodCond.signalAll();
                return ele;
            } finally {
                lock.unlock();
            }
        }
    }

}
