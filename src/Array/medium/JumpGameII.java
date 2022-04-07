package Array.medium;

/**
 * @author gaoyang
 * create on 2022/4/7
 * https://leetcode-cn.com/problems/jump-game-ii/
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int[] jumpAns = new int[nums.length];
        jumpAns[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int num = nums[i];
            if (num == 0) {
                jumpAns[i] = 0;
            } else if (num + i + 1 >= nums.length) {
                jumpAns[i] = 1;
            } else {
                int minNumRange = findMinNumRange(jumpAns, i, i + nums[i]);
                jumpAns[i] = minNumRange == 0 ? 0 : minNumRange + 1;
            }
        }
        return jumpAns[0];
    }

    /**
     * m < n m和n之间最小的步数
     *
     * @param jumpAns
     * @param m
     * @param n
     * @return
     */
    public int findMinNumRange(int[] jumpAns, int m, int n) {
        int minJump = Integer.MAX_VALUE;
        for (int i = m + 1; i <= n && n < jumpAns.length; i++) {
            if (jumpAns[i] == 0) {
                continue;
            }
            minJump = Math.min(minJump, jumpAns[i]);
        }
        return minJump == Integer.MAX_VALUE ? 0 : minJump;
    }

    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }



    public static void main(String[] args) {
        int[] nums = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
        JumpGameII obj = new JumpGameII();
        obj.jump2(nums);
    }

}
