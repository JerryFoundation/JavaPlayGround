package org.jerry.test.leetcode;

/**
 * 用最少的步奏拿完硬币
 *
 * @author zhuqianchao
 * @date 17/9/2020 19:22
 */
public class MinCountCoin {

    public static void main(String[] args) {
        System.out.println(new MinCountCoin().minCount(new int[]{2, 3, 10}));
    }

    public int minCount(int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }

        int n = coins.length;

        int count = 0;

        for (int i = 0; i < n; ++i) {
            if (coins[i] % 2 == 0) {
                count += coins[i] >> 1;
            } else {
                count += coins[i] % 2;
                count += coins[i] >> 1;
            }
        }

        return count;
    }
}
