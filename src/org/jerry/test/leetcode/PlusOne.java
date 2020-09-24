package org.jerry.test.leetcode;

import java.util.Arrays;

/**
 * @author zhuqianchao
 * @date 2020/9/6 23:24
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] a = {9, 9, 9};

        System.out.println(Arrays.toString(new PlusOne().plusOne(a)));
    }


    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
