package PrefixSum.medium;

/**
 * @author gaoyang
 * create on 2022/6/13
 * https://leetcode.cn/problems/binary-subarrays-with-sum/
 */
public class NumSunArrayWithSum {
    /**
     * 双指针算法有点巧妙
     *
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left1 = 0, left2 = 0, sum1 = 0, sum2 = 0, right = 0;
        int ans = 0;
        for (right = 0; right < nums.length; right++) {
            sum1 += nums[right];
            sum2 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1++];
            }
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2++];
            }
            ans += left2 - left1;

        }

        return ans;
    }
}
