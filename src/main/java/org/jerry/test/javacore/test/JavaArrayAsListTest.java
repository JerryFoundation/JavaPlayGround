package org.jerry.test.javacore.test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhuqianchao
 * @date 15/11/2020 21:15
 */
public class JavaArrayAsListTest {

    public static void main(String[] args) {
        int[] myArray = {1, 2, 3};
        List myList = Arrays.asList(myArray);
        //1
        System.out.println(myList.size());
        //数组地址值
        System.out.println(myList.get(0));
        //报错：ArrayIndexOutOfBoundsException
        System.out.println(myList.get(1));
        int[] array = (int[]) myList.get(0);
        System.out.println(array[0]);//1
    }
}
