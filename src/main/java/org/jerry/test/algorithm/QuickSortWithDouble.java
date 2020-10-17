package org.jerry.test.algorithm;

import java.util.Arrays;

/**
 *
 * 使用双指针实现快速排序
 * @author zhuqianchao
 * @date 19/9/2020 11:36
 */
public class QuickSortWithDouble {

    public static void main(String[] args) {
        int[] arr = {1, 23, 4, 3, 25, 189, 11};
        QuickSortWithDouble.quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int startIndex, int endIndex) {

        if (startIndex > endIndex) {
            return;
        }

        // 这里去做排序
        int pivotIndex = partition(arr, startIndex, endIndex);


        // 左边
        quickSort(arr, startIndex, pivotIndex - 1);

        // 右边
        quickSort(arr, pivotIndex + 1, endIndex);
    }


    /**
     * 分治， 根据选定的基准值进行左右排序
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return int
     * @throws
     * @author zhuqianchao
     * @date 19/9/2020 11:41
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 去第一个元素， 也可以是随机从数组任意位置取
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left < right) {

            while (left < right && arr[right] > pivot) {
                right--;
            }

            while (left < right && arr[left] <= pivot) {
                left++;
            }

            // 交换元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        //pivot 和指针重合点交换
        // 也就是 left 和 right 相遇了， 就把起始位置的元素与当前位置元素交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;

    }
}
