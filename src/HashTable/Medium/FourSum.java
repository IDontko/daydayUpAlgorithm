package HashTable.Medium;

import java.util.HashMap;

/**
 * create by gaoyang on 2019/8/28
 * https://leetcode.com/problems/4sum-ii/
 */
public class FourSum {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            int n = A.length;

            if(n == 0) return 0;

            int[] sum1 = new int[n*n];
            int[] sum2 = new int[n*n];
            int res = 0;

            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    sum1[i*n + j] = A[i] + B[j];
                    map.put(sum1[i*n + j], map.getOrDefault(sum1[i*n + j], 0) + 1);
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    sum2[i*n + j] = C[i] + D[j];
                    if(map.containsKey(sum2[i*n + j] * -1)){
                        res += map.get(sum2[i*n + j] * -1);
                    }
                }
            }

            return res;
        }


    public static void main(String[] args) {
        int[] A = { 1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = { 0, 2};
        FourSum fourSum = new FourSum();
        fourSum.fourSumCount(A,B,C,D);

    }
}
