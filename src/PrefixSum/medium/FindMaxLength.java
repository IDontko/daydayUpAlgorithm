package PrefixSum.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoyang
 * create on 2022/6/10
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * https://leetcode.cn/problems/contiguous-array/
 * 具体的，我们在预处理前缀和时，将 nums[i]nums[i] 为 00 的值当做 -1−1 处理。
 *
 * 从而将问题转化为：如何求得最长一段区间和为 00 的子数组。
 *
 * 同时使用「哈希表」来记录「某个前缀和出现的最小下标」是多少。
 *
 * 再结合「如果答案非 00，子数组长度至少为 2」的特性，我们让循环从 2 开始。
 *

 */
public class FindMaxLength {

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + (nums[i - 1] == 1 ? 1 : -1);
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i <= n; i++) {
            if (!map.containsKey(sum[i - 2])) map.put(sum[i - 2], i - 2);
            if (map.containsKey(sum[i])) ans = Math.max(ans, i - map.get(sum[i]));
        }
        return ans;

    }
}
