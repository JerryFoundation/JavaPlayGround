package test.javacore.test;

/**
 * 经典双重检查实现单例
 * @author zhuqianchao
 * @date 22/9/2020 22:35
 */
public class Singleton2 {

    private Singleton2() {
    }


    private static volatile Singleton2 instance;

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
