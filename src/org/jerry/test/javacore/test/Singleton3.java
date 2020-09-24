package org.jerry.test.javacore.test;

/**
 *
 * 内部静态类实现单例
 * @author zhuqianchao
 * @date 22/9/2020 22:35
 */
public class Singleton3 {

    private Singleton3() {
    }

    private static class SingletonPlaceHolder {
        private static final Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return  SingletonPlaceHolder.instance;
    }
}
