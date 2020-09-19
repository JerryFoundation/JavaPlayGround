package test.leetcode;

/**
 * 使用二分查找丢失的数字
 *
 * @author zhuqianchao
 * @date 14/9/2020 22:11
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 9};

        System.out.println(new MissingNumber().missingNumber(a));
    }

    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >> 1;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;

    }
}
