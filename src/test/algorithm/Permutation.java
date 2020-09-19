package test.algorithm;

/**
 * @author zhuqianchao
 * @date 2020/8/31 21:06
 */
public class Permutation {


    public static void main(String[] args) {
        new Permutation().printPermutations(new int[]{1, 2, 3, 4}, 4, 4);
    }

    // 调用方式：
    // int[]a = a={1, 2, 3, 4}; printPermutations(a, 4, 4);
    // k表示要处理的子数组的数据个数
    public void printPermutations(int[] data, int n, int k) {
        if (k == 1) {
            for (int i = 0; i < n; ++i) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < k; ++i) {
            int tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;
            printPermutations(data, n, k - 1);
            tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;
        }
    }
}
