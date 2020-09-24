package org.jerry.test.javacore.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author zhuqianchao
 * @date 2020/8/29 19:26
 */
public class PersonDelegate implements InvocationHandler {

    private Object target;

    public PersonDelegate (Object target) {
        this.target = target;
    }


    public <T> T bind () {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(Arrays.toString(args));

        System.out.println(" =-============ 我说谁");

        return method.invoke(target, args);
    }
}
