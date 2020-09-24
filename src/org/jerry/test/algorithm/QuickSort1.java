package org.jerry.test.algorithm;

import java.util.Arrays;

/**
 * @author zhuqianchao
 * @date 2020/8/29 15:35
 */
public class QuickSort1 {


    public static void quickSort(int[] a) {
        quickSortIn(a, 0, a.length - 1);
    }


    private static void quickSortIn(int[] a, int l, int r) {

        if (l >= r) {
            return;
        }
        int i = partition(a, l, r);
        quickSortIn(a, l, i - 1);
        quickSortIn(a, i + 1, r);
    }


    private static int partition(int[] arr, int low, int high) {
        //指定左指针i和右指针j
        int i = low;
        int j = high;

        //将第一个数作为基准值。挖坑
        int x = arr[low];

        //使用循环实现分区操作
        while (i < j) {
            //1.从右向左移动j，找到第一个小于基准值的值 arr[j]
            while (arr[j] >= x && i < j) {
                j--;
            }
            //2.将右侧找到小于基准数的值加入到左边的（坑）位置， 左指针想中间移动一个位置i++
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            //3.从左向右移动i，找到第一个大于等于基准值的值 arr[i]
            while (arr[i] < x && i < j) {
                i++;
            }
            //4.将左侧找到的打印等于基准值的值加入到右边的坑中，右指针向中间移动一个位置 j--
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }

        //使用基准值填坑，这就是基准值的最终位置
        arr[i] = x;
        //返回基准值的位置索引
        return i;
    }


    public static void main(String[] args) {
        int[] a = {2, 4, 5, 7, 1, 9, 8, 6, 10, 23, 6, 11, 8, 22, 15, 16, 81, 71, 65};

        quickSort(a);

        System.out.println(Arrays.toString(a));
    }


}
