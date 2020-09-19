package test.javacore.test;

import java.util.concurrent.Semaphore;

/**
 * 测试一下 volatile 实现信号
 *
 * @author zhuqianchao
 * @date 19/9/2020 18:33
 */

public class Signal {


    private static volatile int signal = 0;


    static class ThreadA implements Runnable {
        @Override
        public void run() {
            while (signal < 5) {
                if ((signal & 1) == 0) {
                    System.out.println(" ThreadA ---------- ");
                    synchronized (this) {
                        signal++;
                    }
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            while (signal < 5) {
                if ((signal & 1) != 0) {
                    System.out.println(" ThreadB ---------- ");
                    synchronized (this) {
                        signal++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep( 1000L);
        new Thread(new ThreadB()).start();

    }
}
