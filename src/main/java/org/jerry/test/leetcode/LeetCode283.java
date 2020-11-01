package org.jerry.test.leetcode;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author zhuqianchao
 * @date 1/11/2020 09:53
 */
public class LeetCode283 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new LeetCode283().moveZeroes2(nums);

        System.out.println(Arrays.toString(nums));

    }

    public void moveZeroes(int[] nums) {
        int p = removeNums(nums, 0);
        // 移除了多少个 就在数组末尾补上多少个0， 就相当于移动
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }

    /**
     * 移除给定值， 和LeetCode27一样
     *
     * @param nums
     * @param val
     * @return int
     * @throws
     * @author zhuqianchao
     * @date 1/11/2020 10:12
     */
    private int removeNums(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


    public void moveZeroes2(int[] nums)  {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
