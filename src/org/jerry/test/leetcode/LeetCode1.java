package org.jerry.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 *
 * @author zhuqianchao
 * @date 12/10/2020 22:38
 */
public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            // 这里用target和遍历值做差值， 如果差值可以和map中的key匹配
            // 那么证明map中的元素和当前遍历的值之和 等于我们要的target
            if (hashtable.containsKey(target - nums[i])) {
                // 拿到map中key值对应的下标和当前遍历下标 返回数组
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            // 将遍历值当做key存在map， 下标当做值保存起来
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
