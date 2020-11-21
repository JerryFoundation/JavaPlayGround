package org.jerry.test.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author zhuqianchao
 * @date 21/11/2020 14:20
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring2("au"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            // 获取索引 i
            int i = dic.getOrDefault(s.charAt(j), -1);
            // 更新哈希表
            dic.put(s.charAt(j), j);
            // dp[j - 1] -> dp[j]
            tmp = tmp < j - i ? tmp + 1 : j - i;
            // max(dp[j - 1], dp[j])
            res = Math.max(res, tmp);
        }
        return res;
    }


    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j))) {
                // 更新左指针 i
                i = Math.max(i, dic.get(s.charAt(j)));
            }
            // 哈希表记录
            dic.put(s.charAt(j), j);
            // 更新结果
            res = Math.max(res, j - i);
        }
        return res;

    }
}
