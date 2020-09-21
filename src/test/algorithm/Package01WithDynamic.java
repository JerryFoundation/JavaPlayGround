package test.algorithm;

/**
 * 动态规划实现 01背包
 *
 * @author zhuqianchao
 * @date 21/9/2020 20:54
 */
public class Package01WithDynamic {

    public static void main(String[] args) {
        System.out.println(new Package01WithDynamic().knapsack2(new int[]{2, 10, 4, 6, 1}, 5, 9));
        System.out.println(new Package01WithDynamic().knapsack3(new int[]{2, 10, 4, 6, 1}, new int[]{11, 10, 4, 6, 1}
                , 5, 9));
        System.out.println(new Package01WithDynamic().knapsack4(new int[]{2, 10, 4, 6, 1}, new int[]{11, 10, 4, 6, 1}
                , 5, 9));

        Package01WithDynamic.double11advance(new int[]{120, 1, 2, 199, 20}, 5, 200);
    }

    // weight:物品重量，n:物品个数，w:背包可承载重量
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1]; // 默认值false
        // 第一行的数据要特殊处理，可以利用哨兵优化
        states[0][0] = true;
        if (weight[0] <= w) {
            // 放进背包
            states[0][weight[0]] = true;
        }
        // 动态规划状态转移
        for (int i = 1; i < n; ++i) {
            // 不把第i个物品放入背包
            for (int j = 0; j <= w; ++j) {
                if (states[i - 1][j]) {
                    states[i][j] = states[i - 1][j];
                }
            }
            //把第i个物品放入背包
            for (int j = 0; j <= w - weight[i]; ++j) {
                if (states[i - 1][j]) {
                    states[i][j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[n - 1][i]) {
                return i;
            }
        }
        return 0;
    }


    /**
     * 用一位数组动态规划实现
     *
     * @param items
     * @param n
     * @param w
     * @return int
     * @throws
     * @author zhuqianchao
     * @date 21/9/2020 21:14
     */
    public static int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w + 1]; // 默认值false
        states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (items[0] <= w) {
            states[items[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = w - items[i]; j >= 0; --j) {//把第i个物品放入背包
                if (states[j]) {
                    states[j + items[i]] = true;
                }
            }

            // 下面是错误的 ， 不能从前往后遍历
            /*
              这个问题的最终解只需要最后一行数据，所以前面的数据都是临时数据
              如果从前往后循环，比如states[5] = 0,i = 1且重量为4,
              则j = 1时states[j + items[i]] = states[1 + 4] = states[5] = 1，上一层的临时结果在还未被访问时就被覆盖，
              信息丢失，故不可以从前往后计算
             */
//            for (int j = 0; j < w - items[i]; ++j) {
//                if (states[j]) {
//                    states[j + items[i]] = true;
//                }
//            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[i]) {
                return i;
            }
        }
        return 0;
    }


    /**
     * 找到背包中符合重量且价值最大
     *
     * @param weight
     * @param value
     * @param n
     * @param w
     * @return int
     * @throws
     * @author zhuqianchao
     * @date 21/9/2020 21:48
     */
    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        // 初始化states, 默认所有价值为 -1
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < w + 1; ++j) {
                states[i][j] = -1;
            }
        }
        // 初始化0 0 数组值
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; ++i) { //动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第i个物品
                if (states[i - 1][j] >= 0) {
                    states[i][j] = states[i - 1][j];
                }
            }
            for (int j = 0; j <= w - weight[i]; ++j) { // 选择第i个物品
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n - 1][j] > maxvalue) {
                maxvalue = states[n - 1][j];
            }
        }
        return maxvalue;
    }


    /**
     * 用一位数组解决符合重量的价值最大
     *
     * @param weight
     * @param value
     * @param n
     * @param w
     * @return int
     * @throws
     * @author zhuqianchao
     * @date 21/9/2020 21:57
     */
    public static int knapsack4(int[] weight, int[] value, int n, int w) {
        int[] states = new int[w + 1];
        // 初始化states, 默认所有价值为 -1
        for (int j = 0; j < w + 1; ++j) {
            states[j] = -1;
        }
        // 初始化0 数组值
        states[0] = 0;
        if (weight[0] <= w) {
            states[weight[0]] = value[0];
        }
        //动态规划，状态转移
        for (int i = 1; i < n; ++i) {
            for (int j = w - weight[i]; j >= 0; --j) { // 选择第i个物品
                if (states[j] >= 0) {
                    int v = states[j] + value[i];
                    if (v > states[j + weight[i]]) {
                        states[j + weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = w; j >= 0; --j) {
            if (states[j] > maxvalue) {
                maxvalue = states[j];
            }
        }
        return maxvalue;
    }


    /**
     * 在n给商品中 选择商品后 价值 大于等于给定值的最小值
     * <p>
     * 如 满200 减 50 的券 就是 在一堆商品中找到大于等于200的最小值， 来达到 减50 的最大利益
     *
     * @param items
     * @param n
     * @param w
     * @return void
     * @throws
     * @author zhuqianchao
     * @date 21/9/2020 22:12
     */
    // items商品价格，n商品个数, w表示满减条件，比如200
    public static void double11advance(int[] items, int n, int w) {
        boolean[][] states = new boolean[n][2 * w + 1];//超过2倍就没有薅羊毛的价值了
        states[0][0] = true;  // 第一行的数据要特殊处理
        if (items[0] <= 2 * w) {
            states[0][items[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划

            // 不购买第i个商品
            for (int j = 0; j <= 2 * w; ++j) {
                if (states[i - 1][j]) {
                    states[i][j] = states[i - 1][j];
                }
            }

            //购买第i个商品
            for (int j = 0; j <= 2 * w - items[i]; ++j) {
                if (states[i - 1][j]) {
                    states[i][j + items[i]] = true;
                }
            }
        }

        int j;
        for (j = w; j < 2 * w + 1; ++j) {
            if (states[n - 1][j]) {
                // 输出结果大于等于w的最小值
                break;
            }
        }
        // 没有可行解
        if (j == 2 * w + 1) {
            return;
        }
        // i表示二维数组中的行，j表示列
        for (int i = n - 1; i >= 1; --i) {
            // 拿到大于等于给定值的 最小值， 从商品价值列表 从后往前减 如果大于 0  并且， states二维数组上有就打印
            if (j - items[i] >= 0
                    && states[i - 1][j - items[i]]) {
                // 购买这个商品
                System.out.print(items[i] + " ");
                j = j - items[i];
            } // else 没有购买这个商品，j不变。
        }
        if (j != 0) {
            System.out.print(items[0]);
        }
    }
}
