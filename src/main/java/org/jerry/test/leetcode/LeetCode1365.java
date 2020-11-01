package org.jerry.test.leetcode;

import java.util.Arrays;
import java.util.concurrent.atomic.LongAdder;

/**
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * <p>
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * <p>
 * 以数组形式返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 * <p>
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhuqianchao
 * @date 26/10/2020 22:10
 */
public class LeetCode1365 {


    /**
     * 暴力排序
     *
     * @author zhuqianchao
     * @date 26/10/2020 22:32
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int length = nums.length;
        int[] temp = new int[nums.length];
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int num : nums) {
                if (nums[i] > num) {
                    count++;
                }
            }
            temp[i] = count;
        }
        return temp;
    }

    /**
     * 计数排序
     *
     * @author zhuqianchao
     * @date 26/10/2020 22:32
     */
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] cnt = new int[101];
        int n = nums.length;
        for (int num : nums) {
            cnt[num]++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};

        System.out.println(Arrays.toString(new LeetCode1365().smallerNumbersThanCurrent(nums)));
        System.out.println(Arrays.toString(new LeetCode1365().smallerNumbersThanCurrent2(nums)));
    }
}
