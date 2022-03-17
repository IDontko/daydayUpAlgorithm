package HashTable.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoyang
 * create on 2022/3/14
 * https://leetcode-cn.com/problems/number-of-boomerangs/
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。
 *
 * 返回平面上所有回旋镖的数量。

 */
public class NumOfBoomeranges {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer/**distance**/, Integer/**count**/> pointMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length ; j++) {
                int pointOnex = points[i][0];
                int pointOney = points[i][1];
                int pointTwox = points[j][0];
                int pointTwoy = points[j][1];
                int distance = (int) (Math.pow(pointTwox - pointOnex, 2) + Math.pow(pointTwoy - pointOney, 2));
                pointMap.put(distance, pointMap.getOrDefault(distance, 0) + 1);
            }
        }
        int result = 0;
        for (Integer value : pointMap.values()){
            if (value<2){
                continue;
            }
            result += value * (value - 1);
        }
        return result;
    }

    public int numberOfBoomerangs2(int[][] points) {
        int ans = 0;
        for (int[] p : points) {
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            for (int[] q : points) {
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                cnt.put(dis, cnt.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        HashMap<Integer, Integer> test = new HashMap<>();
//        test.put(1,2);
//        test.put(3, test.getOrDefault(3, 0) + 1);
//        System.out.println(test.get(3));
        System.out.println(1<<3);
    }
}
