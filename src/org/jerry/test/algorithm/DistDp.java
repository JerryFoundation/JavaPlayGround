package org.jerry.test.algorithm;

/**
 * 动态规划解决路径问题
 * 前提是不能走回退 只能向右或者向下
 *
 * @author zhuqianchao
 * @date 12/10/2020 21:54
 */
public class DistDp {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 9}, {2, 1, 5, 6}, {5, 7, 8, 10}, {3, 9, 6, 1}};

        System.out.println(new DistDp().minDistDP(matrix, matrix.length));
    }


    public int minDistDP(int[][] matrix, int n) {
        int[][] states = new int[n][n];
        int sum = 0;
        for (int j = 0; j < n; ++j) { // 初始化states的第一行数据
            sum += matrix[0][j];
            states[0][j] = sum;
        }
        sum = 0;
        for (int i = 0; i < n; ++i) { // 初始化states的第一列数据
            sum += matrix[i][0];
            states[i][0] = sum;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < n; ++j) {
                // 剩下的格子 只需要把当前格子的值和 i，j-1 或者 i-1，j 中最小值求和即可
                states[i][j] = matrix[i][j] + Math.min(states[i][j - 1], states[i - 1][j]);
            }
        }
        return states[n - 1][n - 1];
    }
}
