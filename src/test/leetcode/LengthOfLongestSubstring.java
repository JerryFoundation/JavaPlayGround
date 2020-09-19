package test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 查询不重复最长子串的字符个数
 * @author zhuqianchao
 * @date 15/9/2020 19:23
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String a = " ";

        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(a));

    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}
