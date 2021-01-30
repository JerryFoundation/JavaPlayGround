package org.jerry.test.algorithm;

/**
 * @author zhuqianchao
 * @date 29/12/2020 15:16
 */
public class MaxDistance {
        int m, n, ans = 0;
        int[] rowCount, colCount;

        public int maximumDistance(int m, int n) {
            this.m = m;
            this.n = n;
            this.rowCount = new int[m + 1];
            this.colCount = new int[n + 1];
            dfs(0, 0, 0);
            return ans;
        }

        private void dfs(int i, int j, int step) {
            if (i == m && j == n) {
                ans = Math.max(ans, step);
            }
            // 向上走
            if (i > 0 && colCount[j] < 2) {
                ++colCount[j];
                dfs(i - 1, j, step + 1);
                --colCount[j];
            }
            // 向下走
            if (i < m && colCount[j] < 2) {
                ++colCount[j];
                dfs(i + 1, j, step + 1);
                --colCount[j];
            }
            // 向左走
            if (j > 0 && rowCount[i] < 2) {
                ++rowCount[i];
                dfs(i, j - 1, step + 1);
                --rowCount[i];
            }
            // 向左走
            if (j < n && rowCount[i] < 2) {
                ++rowCount[i];
                dfs(i, j + 1, step + 1);
                --rowCount[i];
            }
        }

    public static void main(String[] args) {
        System.out.println(new MaxDistance().maximumDistance(6, 5));
    }
}
