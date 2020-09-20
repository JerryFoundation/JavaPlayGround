package test.javacore.test;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 借助enum特性，实现单例
 * @author zhuqianchao
 * @date 20/9/2020 13:08
 */
public class Singleton {
    private Singleton() {
    }

    private enum SingletonEnum {
        INSTANCE;

        private final Singleton singleton;

        SingletonEnum() {
            singleton = new Singleton();
        }

        private Singleton getInstance() {
            return singleton;
        }
    }

    public static Singleton getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }


    public static void main(String[] args) {
        ExecutorService e = Executors.newFixedThreadPool(2);
        int c = 0;
        while (c < 20) {
            c++;
            System.out.println(c);
            e.execute(() -> System.out.println(Singleton.getInstance()));
        }

        e.shutdown();

    }
}
