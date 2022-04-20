package Array.medium;

/**
 * @author gaoyang
 * create on 2022/4/11
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class UniquePath {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0 && i != 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (i > 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] test = {{0,0}};
        UniquePath up = new UniquePath();
        up.uniquePathsWithObstacles(test);
    }
}
