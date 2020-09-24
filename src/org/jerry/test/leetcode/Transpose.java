package org.jerry.test.leetcode;

import java.util.Arrays;

/**
 * 反转矩阵
 * <p>
 * 1 2 3
 * 4 5 6
 * |||
 * 1 4
 * 2 5
 * 3 6
 *
 * @author zhuqianchao
 * @date 13/9/2020 18:20
 */
public class Transpose {
    public int[][] transpose(int[][] A) {
        // R = 4
        // C = 3
        int R = A.length, C = A[0].length;

        // 提前开辟一个 3行 4列的2维数组
        int[][] ans = new int[C][R];
        // 遍历原二维数组行数
        for (int r = 0; r < R; ++r)
            // 遍历原二维数组列数
            for (int c = 0; c < C; ++c) {
                // 目标数组 和 原数组 进行  行转列
                ans[c][r] = A[r][c];
            }
        return ans;
    }

    public static void main(String[] args) {

        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};

        System.out.println(Arrays.deepToString(new Transpose().transpose(a)));
    }
}
