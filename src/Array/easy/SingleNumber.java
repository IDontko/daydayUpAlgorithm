package Array.easy;

import java.util.Arrays;

/**
 * @author gaoyang
 * create on 2021/11/1
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumber {
    /**
     * 思路1：先排序然后查。
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i == 1 && nums[1] != nums[0]) {
                break;
            } else if (i == nums.length - 1 && nums[i] != nums[i - 1]) {
                result = nums[nums.length - 1] ;
            } else if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                result = nums[i];
            }
        }
        return result;
    }


    /**
     * 官方解题答案，
     * 用异或运算，太牛了
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }


    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        SingleNumber singleNumber = new SingleNumber();
        singleNumber.singleNumber(nums);
    }
}
