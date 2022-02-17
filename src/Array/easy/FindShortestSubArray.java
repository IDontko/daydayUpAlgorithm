package Array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaoyang
 * create on 2022/2/17
 * 给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 *  
 * 输入：nums = [1,2,2,3,1,4,2]
 * 输出：6
 * 解释：
 * 数组的度是 3 ，因为元素 2 重复出现 3 次。
 * 所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        //出现最多的数据
        List<Integer> mostNums = new ArrayList<>();
        //数据出现最多的次数
        int moreNumCount = -1;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > moreNumCount) {
                moreNumCount = map.get(num);
                mostNums.clear();
                mostNums.add(num);
            } else if (map.get(num) == moreNumCount) {
                mostNums.add(num);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length  ; i++) {
            if (!mostNums.contains(nums[i])){
                continue;
            }
            int jCount = moreNumCount;
            for (int j = i; j < nums.length; j++) {
                if (jCount > 0 && nums[j] == nums[i]) {
                    jCount--;
                }
                if (jCount == 0) {
                    result = Math.min(result, j - i + 1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1};
        FindShortestSubArray obj = new FindShortestSubArray();
        obj.findShortestSubArray(nums);
    }
}
