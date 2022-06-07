package PrefixSum.easy;

/**
 * @author gaoyang
 * create on 2022/6/7
 * 寻找数组的中心下标
 * https://leetcode.cn/problems/find-pivot-index/
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if ( (i == 0 ? 0 : nums[i - 1]) == (nums[nums.length - 1] - nums[i])) {
                return i;
            }
        }
        return -1;
    }
}
