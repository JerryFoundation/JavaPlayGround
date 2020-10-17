package org.jerry.test.javacore.test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhuqianchao
 * @date 29/9/2020 21:43
 */
public class CountDownLatchTest {


    static class CountDownTest implements Runnable {

        private final CountDownLatch c;


        public CountDownTest(CountDownLatch c) {
            this.c = c;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(new Random().nextInt(5000));
                System.out.println(Thread.currentThread().getName() + " 我执行完了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                c.countDown();
            }

        }
    }

    static CountDownLatch c = new CountDownLatch(5);

    static ExecutorService e = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() << 1);

    public static void main(String[] args) {


        System.out.println(" 主线程启动");

        for (int i = 0; i < 5; ++i) {
            e.execute(new CountDownTest(c));
        }

        try {
            c.await();
            System.out.println(" 主线程继续执行");


        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } finally {
            if (!e.isShutdown()) {
                e.shutdown();
            }
        }
    }
}
