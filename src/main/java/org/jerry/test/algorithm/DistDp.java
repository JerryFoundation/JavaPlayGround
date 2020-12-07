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

        int n = 4;
        System.out.println(new DistDp().minDist(n - 1, n - 1));

        System.out.println(new DistDp().fib(Integer.MAX_VALUE));
    }


    public int minDistDP(int[][] matrix, int n) {
        int[][] states = new int[n][n];
        int sum = 0;
        // 初始化states的第一行数据
        for (int j = 0; j < n; ++j) {
            sum += matrix[0][j];
            states[0][j] = sum;
        }
        sum = 0;
        // 初始化states的第一列数据
        for (int i = 0; i < n; ++i) {
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


    int[][] matrix = {{1, 3, 5, 9}, {2, 1, 5, 6}, {5, 7, 8, 10}, {3, 9, 6, 1}};
    int[][] mem = new int[4][4];



    public int minDist(int i, int j) {
        if (i == 0 && j == 0) {
            return matrix[0][0];
        }
        if (mem[i][j] > 0) {
            return mem[i][j];
        }
        int minLeft = Integer.MAX_VALUE;
        if (j - 1 >= 0) {
            minLeft = minDist(i, j - 1);
        }
        int minUp = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
            minUp = minDist(i - 1, j);
        }

        int currMinDist = matrix[i][j] + Math.min(minLeft, minUp);
        mem[i][j] = currMinDist;
        return currMinDist;
    }


    public int fib(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 2 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
