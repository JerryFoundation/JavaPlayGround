package org.jerry.test.algorithm;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author zhuqianchao
 * @date 2020/8/29 21:13
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] a = {1, 5, 6, 4, 7, 11, 235, 65};

        selectionSort(a);

        System.out.println(Arrays.toString(a));
    }


    public static void selectionSort(int[] a) {
        // 数组长度
        int n = a.length;
        for (int i = 0; i < n - 1; ++i) {
            // 假定 当前最小值下标是 i
            int minIndex = i;
            // j永远比i快 所以j的最高遍历数是n
            for (int j = i + 1; j < n; ++j) {
                // 遍历后面的元素是否有比当前最小值小的元素存在
                // 如果有 就把那个元素的下标 替换给最小值下标
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换数据  把最小值与当前比较元素进行交换位子
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }
}
