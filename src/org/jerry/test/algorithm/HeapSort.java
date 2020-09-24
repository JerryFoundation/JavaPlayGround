package org.jerry.test.algorithm;

import java.util.Arrays;

/**
 * @author zhuqianchao
 * @date 2020/9/1 22:34
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 6, 8, 12, 11, 23, 21, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 排序
     * <p>
     * 堆元素是从数组下标0开始
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        // 1、建堆
        buildHeap(arr);

        // 2、排序
        int k = arr.length - 1;
        while (k > 0) {
            // 将堆顶元素（最大）与最后一个元素交换位置
            swap(arr, 0, k);
            // 将剩下元素重新堆化，堆顶元素变成最大元素
            heapify(arr, --k, 0);
        }
    }

    /**
     * 建堆
     *
     * @param arr
     */
    private static void buildHeap(int[] arr) {
        // 因为堆是完全二叉树  完全二叉树 后 n/2 都为叶子节点
        // (arr.length - 1) / 2 为最后一个叶子节点的父节点
        // 也就是最后一个非叶子节点，依次堆化直到根节点
        for (int i = (arr.length >>> 1) - 1; i >= 0; i--) {
            heapify(arr, arr.length - 1, i);
        }
    }

    /**
     * 堆化
     *
     * @param arr 要堆化的数组
     * @param n   最后堆元素下标
     * @param i   要堆化的元素下标
     */
    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            // 最大值位置
            int maxPos = i;
            // 与左子节点（i * 2 + 1）比较，获取最大值位置
            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            // 最大值与右子节点（i * 2 + 2）比较，获取最大值位置
            if (i * 2 + 2 <= n && arr[maxPos] < arr[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            // 最大值是当前位置结束循环
            if (maxPos == i) {
                break;
            }
            // 与子节点交换位置
            swap(arr, i, maxPos);
            // 以交换后子节点位置接着往下查找
            i = maxPos;
        }
    }


    /**
     * 交换位置
     *
     * @param arr
     * @param top
     * @param tail
     * @return void
     * @throws
     * @author zhuqianchao
     * @date 2020/9/1 22:37
     */
    private static void swap(int[] arr, int top, int tail) {
        int temp = arr[top];
        arr[top] = arr[tail];
        arr[tail] = temp;
    }

}
