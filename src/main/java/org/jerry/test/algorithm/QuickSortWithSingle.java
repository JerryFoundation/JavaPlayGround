package org.jerry.test.algorithm;

import java.util.Arrays;
/**
 * 用单边循环实现快速排序
 *
 * @author zhuqianchao
 * @date 19/9/2020 12:29
 */
public class QuickSortWithSingle {
    public static void main(String[] args) {
        int[] arr = {29, 23, 4, 3, 25, 189, 11};
        QuickSortWithSingle.quickSortWithSingle(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSortWithSingle(int[] arr, int p, int r) {

        if (p > r) {
            return;
        }
        int pivot = partition(arr, p, r);


        quickSortWithSingle(arr, p, pivot - 1);

        quickSortWithSingle(arr, pivot + 1, r);
    }

    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[p];
        int mark = p;

        for (int i = p + 1; i <= r; ++i) {
            if (arr[i] < pivot) {
                mark++;
                int temp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = temp;
            }
        }

        // 把pivot元素和 mark所在的元素进行交换
        arr[p] = arr[mark];
        arr[mark] = pivot;

        return mark;
    }

}
