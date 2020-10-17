package org.jerry.test.leetcode;

/**
 * @author zhuqianchao
 * @date 2020/9/5 17:56
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int p = 0;

        for (int q = 1; q < nums.length; ++q) {
            if (nums[p] != nums[q]) {
                p++;
                // 将不相等的元素移到左边
                nums[p] = nums[q];
            }
        }

        return p + 1;

    }


    public static void main(String[] args) {
        int[] a = {1,1,1,2,3,5};

        System.out.println(new RemoveDuplicates().removeDuplicates(a));
    }
}
