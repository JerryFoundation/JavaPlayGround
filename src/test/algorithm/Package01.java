package test.algorithm;

/**
 * 0-1 背包的回溯解法
 *
 * @author zhuqianchao
 * @date 15/9/2020 22:51
 */
public class Package01 {

    public int maxW = Integer.MIN_VALUE; //存储背包中物品总重量的最大值

    public static void main(String[] args) {


        int[] a = {25, 7, 8, 9, 11, 23, 5, 76, 4554, 34};
        new Package01().f(0, 0, a, 10, 100);


    }

    // cw表示当前已经装进去的物品的重量和；i表示考察到哪个物品了；
// w背包重量；items表示每个物品的重量；n表示物品个数
// 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
// f(0, 0, a, 10, 100)
    public void f(int i, int cw, int[] items, int n, int w) {
        // cw==w表示装满了;i==n表示已经考察完所有的物品
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        // 当前物品不进背包
        f(i + 1, cw, items, n, w);
        // 已经超过可以背包承受的重量的时候，就不要再装了
        if (cw + items[i] <= w) {
            // 装进背包
            f(i + 1, cw + items[i], items, n, w);
        }
    }
}
