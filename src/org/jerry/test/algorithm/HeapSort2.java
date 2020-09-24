package org.jerry.test.algorithm;

import java.util.Arrays;

/**
 * @author zhuqianchao
 * @date 19/9/2020 15:22
 */
public class HeapSort2 {

    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 6, 8, 10, 11, 23, 21, 9};

        heapSort(arr);


        System.out.println(Arrays.toString(arr));


    }


    public static void downAdjust(int[] arr, int parentIndex, int length) {

        // 保存父节点
        int temp = arr[parentIndex];

        // 左孩子
        int childIndex = 2 * parentIndex + 1;

        while (childIndex < length) {
            // 如果有右孩子 那么就判断一下右孩子是不是比左孩子大， 如果大，就去右孩子找
            if (childIndex + 1 < length && arr[childIndex + 1] > arr[childIndex]) {
                childIndex++;
            }

            // 如果父节点大于任何一个子节点值 就直接跳出
            if (temp > arr[childIndex]) {
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }

        arr[parentIndex] = temp;

    }


    public static void heapSort(int[] arr) {
        // 建堆
        for (int i = (arr.length - 2) >> 1; i >= 0; --i) {
            downAdjust(arr, i, arr.length);
        }

        System.out.println(Arrays.toString(arr));

        for (int i = arr.length - 1; i > 0; i--) { // 最后1个元素和第1个元素进行交换

            int temp = arr[i];

            arr[i] = arr[0];

            arr[0] = temp; // “下沉”调整最大堆

            downAdjust(arr, 0, i);
        }
    }
}
