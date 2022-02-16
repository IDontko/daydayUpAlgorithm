package Array.easy;

/**
 * @author gaoyang
 * create on 2022/2/14
 * 提莫攻击
 * https://leetcode-cn.com/problems/teemo-attacking/
 */
public class FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int expired = 0;
        for (int i = 0; i < timeSeries.length; ++i) {
            if (timeSeries[i] >= expired) {
                ans += duration;
            } else {
                ans += timeSeries[i] + duration - expired;
            }
            expired = timeSeries[i] + duration;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] timeSeries = {1,2};
        int duration = 2;
        FindPoisonedDuration poisonedDuration = new FindPoisonedDuration();
        poisonedDuration.findPoisonedDuration(timeSeries, duration);
    }
}
