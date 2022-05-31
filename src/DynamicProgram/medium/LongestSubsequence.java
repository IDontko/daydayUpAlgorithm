package DynamicProgram.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoyang
 * create on 2022/5/5
 * https://leetcode.cn/problems/longest-arithmetic-subsequence-of-given-difference/
 * 最长等差子序列长度
 */
public class LongestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }

}
