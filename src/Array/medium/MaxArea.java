package Array.medium;

/**
 * @author gaoyang
 * create on 2021/8/6
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai)
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * .
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MaxArea {
    //超出时间限制
    public int maxArea1(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int left = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int right = height[j];
                result = Math.max(result, Math.min(left, right) * (j - i));
            }
        }
        return result;
    }

    public int maxArea2(int[] height){
        int result = 0;
        int left = height[0];
        int right = height[height.length - 1];
        int i = 0 , j = height.length - 1;
        while (i != j) {
//            result = Math.max(result, Math.min(maxLeft, maxRight));
            result = Math.max(result, Math.min(left, right) * (j - i));
            if (left <= right){
                i++;
                left = height[i];
            }else {
                j--;
                right = height[j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height2 = {1,2,1};
        MaxArea area = new MaxArea();
        int result = area.maxArea2(height2);
        System.out.println(result);
    }
}
