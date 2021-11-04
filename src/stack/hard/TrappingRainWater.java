package stack.hard;

/**
 * @author gaoayang
 * create by gaoyang on 2020/7/21
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    /**
     * 解题想法：每个数组元素，向左遍历和向右遍历， 寻找该元素左侧最大值 maxLeft，
     * 右侧最大值 maxRight，该元素这个位置能放多少水，是由两个最大值中比较小的值决定的
     *  结果为 min(maxRight, maxLeft) - height;
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        for (int k = 1; k < height.length - 1; k++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int i = k; i > 0; i--) {
                maxLeft = Math.max(maxLeft, height[i]);
            }

            for (int j = k; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            ans += Math.min(maxLeft, maxRight) - height[k];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(height));
    }
}
