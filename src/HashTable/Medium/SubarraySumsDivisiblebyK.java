package HashTable.Medium;

import java.util.Arrays;

/**
 * create by gaoyang on 2019/8/1
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 */
public class SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] A, int K) {
        int len = A.length;
        if(len<1){
            return 0;
        }
        int[] sum = new int[len+1];
        for(int i =0; i<len;i++){
            sum[i+1] += sum[i]+A[i];
        }
        int[] c = new int[K];
        for(int a:sum){
            c[(a%K+K)%K]++;
        }
        int ans = 0;
        for(int a : c){
            if(a>1){
                a = a * (a-1)/2;
                ans+=a;
            }
        }
        System.out.println(Arrays.toString(sum));
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {4,5,0,-2,-3,1} ;
        int K = 5;
        SubarraySumsDivisiblebyK subarraySumsDivisiblebyK = new SubarraySumsDivisiblebyK();
        subarraySumsDivisiblebyK.subarraysDivByK(A,K);
    }
}
