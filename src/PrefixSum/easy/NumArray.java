package PrefixSum.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyang
 * create on 2022/6/7
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 *
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumArray {
    List<Integer> numList = new ArrayList<>();

    public NumArray(int[] nums) {
        for(int num : nums){
            numList.add(num);
        }
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right ; i++) {
            sum += numList.get(i);
        }
        return sum;
    }
}
