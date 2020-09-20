package test.javacore.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

/**
 * @author zhuqianchao
 * @date 19/9/2020 20:08
 */
public class ThreadLocalDemo {


    static class ThreadA implements Runnable {

        private ThreadLocal<String> threadLocal;


        public ThreadA(ThreadLocal<String> threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("AAAA");

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(threadLocal.get());

        }
    }


    static class ThreadB implements Runnable {
        private ThreadLocal<String> threadLocal;

        public ThreadB(ThreadLocal<String> threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            System.out.println(threadLocal.get());

            threadLocal.set("BBBBBBBBBB");


            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println(threadLocal.get());


        }
    }

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();


        new Thread(new ThreadA(threadLocal)).start();
        new Thread(new ThreadB(threadLocal)).start();


    }
}
