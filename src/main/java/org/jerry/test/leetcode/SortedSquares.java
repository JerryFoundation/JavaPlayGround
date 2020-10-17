package org.jerry.test.leetcode;

import java.util.Arrays;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 * @author zhuqianchao
 * @date 17/9/2020 21:59
 */
public class SortedSquares {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortedSquares()
                .sortedSquares(new int[]{-7, -3, 2, 3, 11})));

    }

    public int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        int i = 0, j = A.length - 1, p = j;
        while (i <= j) {
            // 因为已经提前排序好，
            // 所以左边负数的绝对值如果比右边要大，那么就可以把大的放进临时数组
            if (Math.abs(A[i]) >= A[j]) {
                ans[p] = A[i] * A[i];
                // 原数组下标最小值后移一位
                i++;
            } else {
                // 反之如果是正常大小
                ans[p] = A[j] * A[j];
                // 原数组下标最大值前移一位
                j--;
            }
            // 临时数组下标前移1位
            p--;
        }
        return ans;
    }
}
