package dailyExercise;

/**
 * @author gaoyang
 * create on 2022/5/5
 * https://leetcode.cn/problems/subarray-product-less-than-k/
 * 每日一题
 */
public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int n = nums.length;
        double[] logPrefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            logPrefix[i + 1] = logPrefix[i] + Math.log(nums[i]);
        }
        double logk = Math.log(k);
        int ret = 0;
        for (int j = 0; j < n; j++) {
            int l = 0;
            int r = j + 1;
            int idx = j + 1;
            double val = logPrefix[j + 1] - logk + 1e-10;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (logPrefix[mid] > val) {
                    idx = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            ret += j + 1 - idx;
        }
        return ret;
    }

    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        new NumSubarrayProductLessThanK().numSubarrayProductLessThanK(nums, k);
    }
}
