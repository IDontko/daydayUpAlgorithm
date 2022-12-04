package DynamicProgram.hard;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
            sum += nums[i];
        }
        if (sum < target) {
            return 0;
        }
        if ((sum & 1) != (target & 1)) {
            return 0;
        }
        return subCountTarget(sum, target, nums);
    }

    /**
     * 使用空间状态压缩
     * @param sum
     * @param target
     * @param nums
     * @return
     */
    private int subCountTarget(int sum, int target, int[] nums) {
        int newTarget = (sum - target) /2;
        int[] dp = new int[newTarget + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = newTarget; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[newTarget];

    }


    /**
     * 别人解法
     作者：AC_OIer
     链接：https://leetcode.cn/problems/target-sum/solution/gong-shui-san-xie-yi-ti-si-jie-dfs-ji-yi-et5b/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @param t
     * @return
     */
    public int findTargetSumWays2(int[] nums, int t) {
        int n = nums.length;
        int s = 0;
        for (int i : nums) s += Math.abs(i);
        if (t > s || (s - t) % 2 != 0) return 0;
        int m = (s - t) / 2;
        int[][] f = new int[n + 1][m + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            for (int j = 0; j <= m; j++) {
                f[i][j] += f[i - 1][j];
                if (j >= x) f[i][j] += f[i - 1][j - x];
            }
        }
        return f[n][m];
    }

}
