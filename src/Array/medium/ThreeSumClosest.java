package Array.medium;

import java.util.Arrays;

/**
 * @author gaoyang
 * create on 2021/12/6
 * https://leetcode-cn.com/problems/3sum-closest/
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。

 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
                int sum = nums[i] +  nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(closestSum - target)){
                    closestSum = sum;
                }
                if (sum < target){
                    l++;
                }else if (sum > target){
                    r--;
                }else {
                    return target;
                }
            }

        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,1,-3};
        int target = 1;
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        threeSumClosest.threeSumClosest(nums, target);
    }
}
