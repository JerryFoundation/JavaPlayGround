package org.jerry.test.javacore.test;

import java.util.concurrent.CyclicBarrier;

/**
 * @author zhuqianchao
 * @date 26/9/2020 14:17
 */
public class ThreadStudy {
    static final int COUNT = 6;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < COUNT; i++) {
            new Thread(new Staff(i, cb)).start();
        }
//        synchronized (ThreadStudy.class) {
//            ThreadStudy.class.wait();
//        }
    }

    static CyclicBarrier cb = new CyclicBarrier(COUNT, new Singer());

    static class Singer implements Runnable {

        @Override
        public void run() {
            System.out.println("为大家唱歌。。。");
        }

    }

    static class Staff implements Runnable {

        CyclicBarrier cb;
        int num;

        Staff(int num, CyclicBarrier cb) {
            this.num = num;
            this.cb = cb;
        }

        @Override
        public void run() {
            System.out.printf("员工(%d)出发。。。", num);
            doingLongTime();
            System.out.printf("员工(%d)到达地点一。。。", num);
            try {
                cb.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.printf("员工(%d)再出发。。。", num);
            doingLongTime();
            System.out.printf("员工(%d)到达地点二。。。", num);
            try {
                cb.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.printf("员工(%d)再出发。。。", num);
            doingLongTime();
            System.out.printf("员工(%d)到达地点三。。。", num);
            try {
                cb.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.printf("员工(%d)结束。。。", num);
        }

        private void doingLongTime() {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
