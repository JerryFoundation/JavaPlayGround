package org.jerry.test.algorithm;

/**
 * 查找最后一个值是给定值的
 *
 * @author zhuqianchao
 * @date 2020/8/27 21:09
 */
public class BinarySearch2 {

    public static void main(String[] args) {

        int[] a = {1, 2, 2, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 7};

        System.out.println(binarySearch(a, a.length, 2));

    }


    public static int binarySearch(int[] a, int n, int value) {
        return binaryIn(a, 0, n - 1, value);
    }


    private static int binaryIn(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);

        if (a[mid] < value) {
            return binaryIn(a, mid + 1, high, value);
        } else if (a[mid] > value) {
            return binaryIn(a, low, mid - 1, value);
        }

        // 如果mid 已经是最后一个了 或者  mid + 1的值已经和给定值不一样了就返回
        if ((mid == high) || (a[mid + 1] != value)) {
            return mid;
        } else {
            // mid + 1的值还是和给定值一样说明不是最后一个
            // 说明还有值在 mid + 1 到 high 区间内 ，所以继续递归求值
            return binaryIn(a, mid + 1, high, value);
        }
    }
}
