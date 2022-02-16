package Array.easy;

/**
 * @author gaoyang
 * create on 2022/2/16
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 *
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 */
public class FindMaxAverage {

    //超时
    public double findMaxAverage(int[] nums, int k) {
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int count = nums[i];
            for (int j = 1; j < k; j++) {
                count += nums[i+j];
            }
            if (count > maxCount){
                maxCount = count;
            }
        }
        return (double)maxCount/k;
    }
    public double findMaxAverage2(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }



    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        FindMaxAverage obj = new FindMaxAverage();
        obj.findMaxAverage(nums,k);
    }
}
