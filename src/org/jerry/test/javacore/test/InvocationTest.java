package org.jerry.test.javacore.test;

/**
 * @author zhuqianchao
 * @date 2020/8/29 19:29
 */
public class InvocationTest {
    public static void main(String[] args) {

        Woman woman = new Woman();

        PersonDelegate personDelegate = new PersonDelegate(woman);

        PersonInterface person = personDelegate.bind();

        person.say();

        person.run(5);
    }
}
