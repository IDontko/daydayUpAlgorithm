package PrefixSum.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author gaoyang
 * create on 2022/6/27
 * 给你一份工作时间表hours，上面记录着某一位员工每天的工作小时数。
 * <p>
 * 我们认为当员工一天中的工作小时数大于8 小时的时候，那么这一天就是「劳累的一天」。
 * <p>
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * <p>
 * 请你返回「表现良好时间段」的最大长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-well-performing-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestWPI {

    /**
     * 前缀和 + 单调栈，单调栈很难理解哦。
     * @param hours
     * @return
     */
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int ans = 0;
        int[] presum = new int[n];
        presum[0] = hours[0] > 8 ? 1 : -1;
        for (int i = 1; i < n; i++) {
            int temp = hours[i] > 8 ? 1 : -1;
            presum[i] = presum[i - 1] + temp;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deque.isEmpty() || presum[deque.peek()] > presum[i]) {
                deque.push(i);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && presum[deque.peek()] < presum[i]) {
                int index = deque.pop();
                ans = Math.max(ans, i - index);
            }
            if (presum[i] > 0) {
                ans = Math.max(ans, i + 1);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] hours = {9, 9, 6, 0, 6, 6, 9};
        new LongestWPI().longestWPI(hours);
    }
}
