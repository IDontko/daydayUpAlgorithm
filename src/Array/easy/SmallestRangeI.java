package Array.easy;

import java.util.Arrays;

/**
 * @author gaoyang
 * create on 2022/2/25
 */
public class SmallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        Arrays.sort(nums);
        int lowest = nums[0];
        int highest = nums[nums.length - 1];
        int sub = highest - lowest - k - k;
        return Math.max(sub, 0);
    }
}
