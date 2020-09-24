package org.jerry.test.leetcode;

/**
 * @author zhuqianchao
 * @date 2020/9/6 11:32
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            if (ans < sum) {
                ans = sum;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {7, -2, 5, 1, -1, 7};
        System.out.println(new MaxSubArray().maxSubArray(a));
    }

}
