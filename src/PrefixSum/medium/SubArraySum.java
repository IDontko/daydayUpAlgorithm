package PrefixSum.medium;

import java.util.HashMap;

/**
 * @author gaoyang
 * create on 2022/6/13
 * <p>
 * 给你一个整数数组 nums 和一个整数k ，请你统计并返回 该数组中和为k的子数组的个数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubArraySum {

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)){
                count += map.get(pre -k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);

        }
        return count;
    }
}
