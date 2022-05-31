package DynamicProgram.hard;

import java.util.Arrays;

/**
 * @author gaoyang
 * create on 2022/5/9
 * https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended-ii/
 * 定义 f[i][j]f[i][j] 为考虑前 ii 个事件，选择不超过 jj 的最大价值
 * <p>
 * 对于每个事件，都有选择与不选两种选择：
 * <p>
 * 不选： f[i][j] = f[i - 1][j]f[i][j]=f[i−1][j]
 * 选：找到第 ii 件事件之前，与第 ii 件事件不冲突的事件，记为 last，则有 f[i][j] = f[last][j - 1] + value_if[i][j]=f[last][j−1]+value
 * i
 * 两者取 maxmax，则是 f[i][j]f[i][j] 的值。
 * <p>
 * 分析到这里，因为我们要找 last，我们需要先对 events 的结束时间排序，然后找从右往左找，找到第一个满足 结束时间 小于 当前事件的开始时间 的事件，就是 last
 * <p>
 * 而找 last 的过程，可以直接循环找，也可以通过二分来找，都能过。
 * <p>
 * 作者：AC_OIer
 * 链接：https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended-ii/solution/po-su-dp-er-fen-dp-jie-fa-by-ac_oier-88du/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxValue {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            int[] event = events[i - 1];
            int start = event[0];
            int value = event[2];
            int last = 0;
            for (int j = i - 1; j >= 1; j--) {
                int[] prev = events[j - 1];
                if (prev[1] < start) {
                    last = j;
                    break;
                }
            }
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[last][j - 1] + value);
            }
        }
        return dp[n][k];
    }
}
