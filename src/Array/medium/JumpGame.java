package Array.medium;

/**
 * @author gaoyang
 * create on 2022/4/11
 * https://leetcode-cn.com/problems/jump-game/
 * 思路：最远到达距离是否是0，如果是0则说明无法到达终点
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int maxPosition = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (nums[i] == 0 && maxPosition == i ){
                return false;
            }
        }
        return true;
    }
}
