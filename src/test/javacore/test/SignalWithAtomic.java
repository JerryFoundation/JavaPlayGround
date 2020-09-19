package test.javacore.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * 测试一下 volatile 实现信号
 *
 * @author zhuqianchao
 * @date 19/9/2020 18:33
 */

public class SignalWithAtomic {


    private static final AtomicInteger signal = new AtomicInteger(0);


    static class ThreadA implements Runnable {
        @Override
        public void run() {
            while (signal.getAcquire() < 5) {
                if ((signal.getAcquire() & 1) == 0) {
                    System.out.println(" ThreadA ---------- ");
                    signal.getAndIncrement();
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            while (signal.getAcquire() < 5) {
                if ((signal.getAcquire() & 1) != 0) {
                    System.out.println(" ThreadB ---------- ");
                    signal.getAndIncrement();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
    }
}
