package org.jerry.test.javacore.test;

/**
 * @author zhuqianchao
 * @date 26/9/2020 13:38
 */
public class ThreadJoinTest {

    static int count;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            synchronized (ThreadJoinTest.class) {
                while (count < 10000) {
                    count++;
                }
            }
        });
        thread.start();
        thread.join();
        System.out.println(count);
    }
}
