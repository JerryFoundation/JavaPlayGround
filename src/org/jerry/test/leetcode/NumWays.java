package org.jerry.test.leetcode;

/**
 * 青蛙跳台阶
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * @author zhuqianchao
 * @date 14/9/2020 22:35
 */
public class NumWays {

    public static void main(String[] args) {
        new Thread(() ->
                System.out.println(new NumWays().numWays(43) + " aaaa")).start();
        new Thread(() ->
                System.out.println(new NumWays().numWays2(43) + "  bbbbb")).start();
    }

    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return (numWays(n - 1) + numWays(n - 2)) % 1000000007;
    }

    public int numWays2(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
