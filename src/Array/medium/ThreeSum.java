package Array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gaoyang
 * create on 2021/10/21
 * https://leetcode-cn.com/problems/3sum/
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i++) {
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for (int j = i + 1; j < nums.length ; j++) {
                int ijSum = nums[i] + nums[j];
                if (ijSum <= 0){
                    for (int k = nums.length - 1; k > j ; k--) {
                        if (ijSum + nums[k] < 0){
                            break;
                        }
                        if (ijSum + nums[k] > 0){
                            continue;
                        }
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                    }
                }

            }

        }
        return result;
    }

    public List<List<Integer>> threeSumMethod2(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2){
            return ans;
        }

        Arrays.sort(nums); // O(nlogn)
        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0) {
                break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 去掉重复情况
            }
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++; right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }
}
