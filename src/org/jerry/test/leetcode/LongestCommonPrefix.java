package org.jerry.test.leetcode;

/**
 * 最长公共前缀
 * <p>
 * <p>
 * flower
 * <p>
 * flow
 * <p>
 * flight
 *
 * @author zhuqianchao
 * @date 15/9/2020 20:39
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix()
                .longestCommonPrefix(new String[]{"ab", "a"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int n = strs.length;
        int length = strs[0].length();
        for (int i = 0; i < length; ++i) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < n; ++j) {

                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];

    }
}
