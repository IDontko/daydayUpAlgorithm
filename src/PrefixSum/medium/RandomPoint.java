package PrefixSum.medium;

import java.util.Random;

/**
 * @author gaoyang
 * create on 2022/7/1
 * https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/submissions/
 * https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/solution/by-ac_oier-mhi6/
 * 前缀和加二分。
 */
public class RandomPoint {
    int n;
    int[] sum;
    int[][] rs;
    Random random;

    public RandomPoint(int[][] rects) {
        random = new Random();
        rs = rects;
        n = rs.length;
        sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int a = rs[i - 1][0], b = rs[i - 1][1], x = rs[i - 1][2], y = rs[i - 1][3];
            //sum定义的是矩形内数量组的面积
            sum[i] = sum[i - 1] + ((x - a + 1) * (y - b + 1));
        }
    }

    public int[] pick(){
        int val =random.nextInt(sum[n]) + 1;
        int left = 0;
        int right = n;
        while (left < right){
            int mid = (right + left) /2;
            if (sum[mid] >= val){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        int[] cur = rs[right - 1];
        int x = random.nextInt(cur[2] - cur[0] + 1) + cur[0], y = random.nextInt(cur[3] - cur[1] + 1) + cur[1];
        return new int[]{x, y};
    }
}
