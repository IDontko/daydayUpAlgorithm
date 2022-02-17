package Array.easy;

/**
 * @author gaoyang
 * create on 2022/2/17
 * 最长连续递增序列
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[j - 1]) {
                    result = Math.max(result, j - i + 1);
                } else {
                    break;
                }

            }
        }
        return result;
    }

    /**
     * 更加巧妙的解法
     * @param nums
     * @return
     */
    public int findLengthOfLCIS2(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        FindLengthOfLCIS obj = new FindLengthOfLCIS();
        int[] nums = {2,2,2,2,2};
        obj.findLengthOfLCIS(nums);
    }
}
