package test.javacore.test;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 证明一下 arrylist的 initialCapacity不会在初始化的时候生效
 *
 * @author zhuqianchao
 * @date 20/9/2020 10:19
 */
public class ArrayListInitTest {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(1000000);


//        long start = System.currentTimeMillis();
//        System.out.println(start);
//        int c = 0;
//        while (c < 1000000) {
//            arrayList.add(c);
//            ++c;
//        }
//        System.out.println(System.currentTimeMillis() - start);
    }
}
