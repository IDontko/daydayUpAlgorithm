package stack.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author create on 2021/6/15
 * https://leetcode-cn.com/problems/132-pattern/
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，
 * 并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 */
public class Patter132 {

    //    public static boolean find132pattern(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] > nums[i]){
//                    for (int k = j + 1; k < nums.length ; k++) {
//                        if (nums[k] > nums[i] && nums[k] < nums[j]){
//                            return true;
//                        }
//                    }
//                }
//
//            }
//
//        }
//        return false;
//    }
    public static boolean find132pattern(int[] nums) {
        int len = nums.length;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int maxK = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; --i) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!deque.isEmpty() && nums[i] > deque.peek()) {
                maxK = deque.pop();
            }
            if (nums[i] > maxK) {
                deque.push(nums[i]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {-1,3,2,0};
        int[] nums4 = {3,5,0,3,4};
        int[] nums5 = {1,3,2,4,5,6,7,8,9,10};
        System.out.println(find132pattern(nums5));
    }
}
