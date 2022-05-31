package DynamicProgram.medium;

/**
 * @author gaoyang
 * create on 2022/5/3
 * https://leetcode.cn/problems/longest-common-subsequence/
 * 最长公共子序列的长度
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    //宫水三叶解法
    public int longestCommonSubsequence2(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        s1 = " " + s1; s2 = " " + s2;
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int[][] f = new int[n + 1][m + 1];

        // 因为有了追加的空格，我们有了显然的初始化值（以下两种初始化方式均可）
        // for (int i = 0; i <= n; i++) Arrays.fill(f[i], 1);
        for (int i = 0; i <= n; i++) f[i][0] = 1;
        for (int j = 0; j <= m; j++) f[0][j] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (cs1[i] == cs2[j]) {
                    f[i][j] = f[i -1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }

        // 减去最开始追加的空格
        return f[n][m] - 1;
    }

}
