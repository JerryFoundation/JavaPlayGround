package org.jerry.test.algorithm;

import java.util.Arrays;

/**
 * @author zhuqianchao
 * @date 7/12/2020 22:00
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int[] arr = {6, 1, 23, 4, 3, 25, 189, 11};
        new QuickSort2().quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }


    private void quickSort(int[] nums, int left, int right) {
        int low = left;
        int high = right;
        if (low > high) {
            return;
        }
        int p = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= p) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= p) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = p;
        quickSort(nums, left, low - 1);
        quickSort(nums, low + 1, right);
    }

}
