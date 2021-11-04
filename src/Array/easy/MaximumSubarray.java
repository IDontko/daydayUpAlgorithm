package Array.easy;

/**
 * @author gaoyang
 * create on 2021/10/14
 * 最大子序和
 *给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        //定义和
        int res = nums[0];
        int sum = 0;
        //如果sum小于0，则后面的子序列不包含目前的序列，如果sum大于0 ,则目前的序列对于后面的序列是有好处的。
        //Math.max(res,sum)保证可以找到最大值。
        for (int num: nums) {
            if (sum > 0){
                sum += num;
            }else {
                sum = num;
            }
            res = Math.max(sum, res);

        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray subarray = new MaximumSubarray();
        subarray.maxSubArray(nums);
    }
}
