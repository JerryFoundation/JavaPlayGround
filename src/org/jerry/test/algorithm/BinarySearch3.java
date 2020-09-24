package org.jerry.test.algorithm;

/**
 * 查找第一个大于等于给定值的元素
 *
 * @author zhuqianchao
 * @date 2020/8/27 21:09
 */
public class BinarySearch3 {

    public static void main(String[] args) {

        int[] a = {3, 4, 6, 7, 7, 8, 9};

        System.out.println(binarySearch(a, a.length, 6));

    }


    public static int binarySearch(int[] a, int n, int value) {
        return binaryIn(a, 0, n - 1, value);
    }


    private static int binaryIn(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);

        // 由于要查找第一个大于给定值的下面，那么凡事下标取值小于或者等于给定值的统统忽略重新递归
        // 区间缩小到 mid + 1 到high
        if (a[mid] <= value) {
            return binaryIn(a, mid + 1, high, value);
        }
        // a[mid] > value
        // 找到 下标值大于给定值， 如果此时mid 已经是最低的下标了 那么直接返回就好
        // 或者 mid - 1 的值 小于 或者 等于给定值， 那么认为此时的下标所存储的值已经是第一个大于给定值了
        if (mid == low || a[mid - 1] <= value) {
            return mid;
        }
        // 如果mid - 1的值 仍然大于给定值， 那么证明前面还有比给定值大的
        // 当前获取的下标做存储的值，并不是第一个比给定值大的
        // 我们就缩小范围继续递归， 这时候区间就是 low  到 mid -1
        return binaryIn(a, low, mid - 1, value);
    }
}
