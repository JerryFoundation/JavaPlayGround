package test.leetcode.playground;

/**
 * @author zhuqianchao
 * @date 2020/9/12 19:11
 */
// "static void main" must be defined in a public class.
public class StringTest {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        int n = 100000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            s.append("hello");
        }

        System.out.println(System.currentTimeMillis() - start);

        System.out.println(s);
    }
}