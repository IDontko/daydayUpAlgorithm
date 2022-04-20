package Array.medium;

/**
 * @author gaoyang
 * create on 2022/4/15
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                dp[i] = dp[i - 1] + prices[i] - prices[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        MaxProfit maxProfit = new MaxProfit();
        maxProfit.maxProfit(prices);
    }
}
