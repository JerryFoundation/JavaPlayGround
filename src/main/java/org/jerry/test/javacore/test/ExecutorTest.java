package org.jerry.test.javacore.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhuqianchao
 * @date 26/9/2020 13:49
 */
public class ExecutorTest {

    static class TestThread implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
            service.execute(new TestThread());
        }

        ExecutorService service2 = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            service2.execute(new TestThread());
        }

        ExecutorService service3 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() << 1);
        for (int i = 0; i < 100; i++) {
            service3.execute(new TestThread());
        }

        ExecutorService service4 = Executors.newWorkStealingPool();
        for (int i = 0; i < 100; i++) {
            service4.execute(new TestThread());
        }
        service.shutdown();
        service2.shutdown();
        service3.shutdown();
        service4.shutdown();

    }
}
