package org.jerry.test.algorithm;

import java.util.Random;

/**
 * @author zhuqianchao
 * @date 2020/8/26 22:49
 */
public class SimpleBinarySearch {

    public static void main(String[] args) {

        int[] a = new int[100000];
        Random r = new Random();
        for (int i = 0 ; i< a.length -1 ; ++i) {
            a[i] = r.nextInt(9999);
        }

        long start = System.currentTimeMillis();
        int index = bSearch(a, 100000, 8020);

        System.out.println(System.currentTimeMillis() - start);
        System.out.println(index);
    }


    public static int bSearch(int[] a, int n, int value) {
        return bSearchInternally(a, 0, n - 1, value);
    }

    private static int bSearchInternally(int[] a, int low, int high, int value) {
        // 退出递归
        if (low > high) {
            return -1;
        }

        // 获取二分值mid
        int mid = low + ((high - low) >> 1);

        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            // 给定值大于中间值
            return bSearchInternally(a, mid + 1, high, value);
        } else {
            // 给定值小于中间值
            return bSearchInternally(a, low, mid - 1, value);
        }
    }
}
