package org.jerry.test.leetcode;

/**
 * @author zhuqianchao
 * @date 1/11/2020 09:45
 */
public class LeetCode27 {


    public static void main(String[] args) {
        System.out.println(new LeetCode27().removeElement(new int[]{0, 1, 2, 2, 3}, 2));
    }


    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            // 如果快指针不等于给定值， slow就+1 否则就略过
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
