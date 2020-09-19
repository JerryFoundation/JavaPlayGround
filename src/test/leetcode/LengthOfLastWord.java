package test.leetcode;

/**
 * @author zhuqianchao
 * @date 2020/9/6 22:51
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "Hello World";

        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
    }

    int count = 0;

    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int index = s.lastIndexOf(' ');
        int n = s.length() - 1;
        if (n - index > 0) {
            while (n - index > 0) {
                ++count;
                --n;
            }
        } else {
            String s1 = s.substring(0, index);
            lengthOfLastWord(s1);
        }
        return count;
    }
}
