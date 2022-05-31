package DynamicProgram.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaoyang
 * create on 2022/5/6
 * https://leetcode.cn/problems/minimum-operations-to-make-a-subsequence/
 * 得到子序列的最少操作次数
 */
public class MinOperations {

    public int minOperations(int[] target, int[] arr) {
        int n = target.length;
        Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; ++i) {
            pos.put(target[i], i);
        }
        List<Integer> d = new ArrayList<Integer>();
        for (int val : arr) {
            if (pos.containsKey(val)) {
                int idx = pos.get(val);
                int it = binarySearch(d, idx);
                if (it != d.size()) {
                    d.set(it, idx);
                } else {
                    d.add(idx);
                }
            }
        }
        return n - d.size();
    }

    public int binarySearch(List<Integer> d, int target) {
        int size = d.size();
        if (size == 0 || d.get(size - 1) < target) {
            return size;
        }
        int low = 0, high = size - 1;
        while (low < high) {
            int mid = (high + low) >> 1;
            if (d.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        int[] target = {6,4,8,1,3,2};
        int[] arr = {4,7,6,2,3,8,6,1};
        new MinOperations().minOperations(target, arr);
    }
}
