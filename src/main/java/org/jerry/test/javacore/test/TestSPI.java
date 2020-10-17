package org.jerry.test.javacore.test;

import java.util.ServiceLoader;

/**
 * @author zhuqianchao
 * @date 17/10/2020 14:50
 */
public class TestSPI {
    public static void main(String[] args) {
        ServiceLoader<Hello> helloServiceLoader = ServiceLoader.load(Hello.class);

        for (Hello hello : helloServiceLoader) {
            hello.say();
        }
    }
}
