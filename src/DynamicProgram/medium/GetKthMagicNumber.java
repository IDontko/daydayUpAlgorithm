package DynamicProgram.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author gaoyang
 * create on 2022/4/20
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 5
 * <p>
 * 输出: 9
 */
public class GetKthMagicNumber {
    /**
     * dp数组的方式解决
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0] = 1;
        int p0 = 0, p1 = 0, p2 = 0;
        for (int i = 1; i < k; i++) {
            int v1 = dp[p0] * 3;
            int v2 = dp[p1] * 5;
            int v3 = dp[p2] * 7;
            int min = v1 < v2 ? v1 : v2;
            min = min < v3 ? min : v3;
            dp[i] = min;
            if (min == v1) {
                p0++;
            }
            if (min == v2) {
                p1++;
            }
            if (min == v3) {
                p2++;
            }
        }
        return dp[k - 1];
    }

    /**
     * 小顶堆
     * @param k
     * @return
     */
    public int getKthMagicNumber2(int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        Set<Integer> set = new HashSet<>();
        while (true) {
            Integer val = priorityQueue.poll();
            if (!set.contains(val)) {
                set.add(val);
                priorityQueue.add(3 * val);
                priorityQueue.add(5 * val);
                priorityQueue.add(7 * val);
            }
            if (set.size() == k){
                return val.intValue();
            }
        }
    }



}
