package test.algorithm;

import java.util.Arrays;

/**
 * 计数排序
 *
 * @author zhuqianchao
 * @date 19/9/2020 17:09
 */
public class CountSort {

    public static void main(String[] args) {
        int[] array = new int[]{95, 94, 91, 98, 99, 90, 99, 93, 91, 92};

        int[] sortedArray = countSort(array);

        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] countSort(int[] array) {
        int max = array[0];
        int min = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }

            if (array[i] < min) {
                min = array[i];
            }
        }

        // 计算出差值区间
        int d = max - min;

        // 创建统计数组，并统计元素个数, 使用最小值作为区间基准
        int[] countArray = new int[d + 1];
        for (int i = 0; i < array.length; ++i) {
            countArray[array[i] - min]++;
        }
        // 统计数组做变形，后面的元素等于前面的元素之和
        for (int i = 1; i < countArray.length; ++i) {
            countArray[i] += countArray[i - 1];
        }

        // 倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
        int[] sortArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; --i) {
            sortArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }

        return sortArray;
    }
}
