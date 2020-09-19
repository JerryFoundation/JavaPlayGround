package test.leetcode;

import java.util.Arrays;

/**
 * 让奇数放在偶数前面
 *
 * @author zhuqianchao
 * @date 17/9/2020 19:30
 */
public class Exchange {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Exchange().exchange(new int[]{5, 7, 6, 3, 2, 5, 6, 7})));
    }

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int n = nums.length;
        // 定义2个 指针， 一个在前 一个在后
        int p = 0, r = n - 1, temp;
        while (p < r) {
            // 左边已经是奇数了， 就往前前指针移动 1位
            if ((nums[p] & 1) != 0) {
                p++;
            } else {
                temp = nums[p];
                nums[p] = nums[r];
                nums[r] = temp;
                r--;
            }
        }

        return nums;

    }
}
