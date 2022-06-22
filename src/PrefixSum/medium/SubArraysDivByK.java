package PrefixSum.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoyang
 * create on 2022/6/20
 * https://leetcode.cn/problems/subarray-sums-divisible-by-k/
 * 千万不再用双层循环了
 * 真垃圾的方法。
 */
public class SubArraysDivByK {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            int mod = (sum % k + k) % k;
            int same = map.getOrDefault(mod, 0);
            ans += same;
            map.put(mod, same + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;

        new SubArraysDivByK().subarraysDivByK(nums, k);
    }
}
