package Array.easy;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDisappearNum {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums){
            set.add(i);
        }
        for (int i = 1; i < nums.length + 1 ; i++) {
            if (!set.contains(i)){
                result.add(i);
            }

        }
        return result;
    }

    /**
     * 优秀的解法
     * 在原数组上进行一次遍历，在遍历的过程中，将遇到的元素所对应的index下的元素标记为负。
     * 最终那些index下的元素没有被标记的则说明，这个index对应的元素没有出现过。
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            int index =  Math.abs(nums[i]) - 1;
            nums[index]  = -Math.abs(nums[index]);

        }
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] > 0){
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        FindDisappearNum findDisappearNum= new FindDisappearNum();
        findDisappearNum.findDisappearedNumbers(nums);
    }

}
