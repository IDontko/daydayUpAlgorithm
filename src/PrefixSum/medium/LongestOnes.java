package PrefixSum.medium;

/**
 * @author gaoyang
 * create on 2022/6/22
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 要掌握
 */
public class LongestOnes {

    /**
     * 前缀和 +  二分法实现
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        int[] P = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            P[i] = P[i - 1] + (1 - nums[i - 1]);
        }
        int ans = 0;
        for (int right = 0; right < P.length ; right++) {
            int left = binarySearch(P, P[right+1] - k);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    private int binarySearch(int[] p, int target) {
        int low = 0;
        int high = p.length  -1;
        while(low < high){
            int mid = (high - low) / 2 + low;
            if (p[mid] < target){
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }

    /**
     * 用滑动窗口实现
     */
    public int longestOnes2(int[] nums, int k) {
        int lSum = 0;
        int rSum = 0;
        int ans = 0;
        int left =0;
        for (int right = 0; right < nums.length; right++) {
            rSum += 1 - nums[right];
            while (lSum < rSum - k){
               lSum +=  1 - nums[left];
               left++;
            }
            ans = Math.max(ans, right - left + 1);

        }
        return ans;
    }

}
