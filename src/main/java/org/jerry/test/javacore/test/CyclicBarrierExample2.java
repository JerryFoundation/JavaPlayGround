package org.jerry.test.javacore.test;

import java.util.concurrent.*;

/**
 * @author zhuqianchao
 * @date 29/9/2020 22:01
 */
public class CyclicBarrierExample2 {
    // 请求的数量
    private static final int threadCount = 550;
    // 需要同步的线程数量
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
        System.out.println(" ============== after ");
    });

    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException | BrokenBarrierException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }

    public static void test(int threadnum) throws InterruptedException, BrokenBarrierException {
        System.out.println("threadnum:" + threadnum + "is ready");
        try {
            cyclicBarrier.await(10000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("-----CyclicBarrierException------");
        }

        System.out.println("threadnum:" + threadnum + "is finish");
    }

}
