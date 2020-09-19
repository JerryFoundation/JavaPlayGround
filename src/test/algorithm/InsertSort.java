package test.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhuqianchao
 * @date 2020/8/25 21:49
 */
public class InsertSort {

    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找要插入的位置并移动数据
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }


    public static void main(String[] args) {
        int[] a = new int[10000];
        Random r = new Random();
        for (int i = 0 ; i< a.length -1 ; ++i) {
            a[i] = r.nextInt(10000);
        }
        insertionSort(a, 10000);

        System.out.println(Arrays.toString(a));
    }
}
