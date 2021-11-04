package HashTable.Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * create by gaoyang on 2019/7/24
 * https://leetcode.com/problems/longest-string-chain/
 */

public class LongestStringChain {
    private int topDown(String[] words, int i, Map<String, Integer> map, int[] cache) {
        if(cache[i] != 1) return cache[i];
        for(int j=0; j<words[i].length(); j++) {
            String s = words[i];
            String ss = s.substring(0,j) + s.substring(j+1,s.length());
            if(map.containsKey(ss)) {
                cache[i] = Math.max(cache[i], 1+topDown(words, map.get(ss), map, cache));
            }
        }
        return cache[i];
    }

    public int longestStrChain(String[] words) {
        int n = words.length, max = 0;
        int[] cache = new int[n];
        Arrays.fill(cache, 1);
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<=n-1; i++) map.put(words[i], i);
        for (int i=0; i<=n-1; i++) {
            max = Math.max(max, topDown(words, i, map, cache));
        }
        return max;
    }

    public int longestStrChain2(String[] words) {
        int len = words.length;
        /* 将字符串按照字典序重新排列 */
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        /* dp[i] 表示 到 words[i] 为止最长的词链长度 */
        int[] dp = new int[len];
        for(int i = 0; i < len - 1; i++) {
            String a = words[i];
            for (int j = i + 1; j < len; j++) {
                String b = words[j];
                /* 判断 words[i] 是否是 words[j] 的前身 */
                if (isPredecessor(a, b)) {
                    dp[j] = Math.max(dp[j], dp[i]+1);
                }

            }

        }
        /* 得到最终结果，由于最末尾的字符串不一定在最终词链里，因此dp[len-1]不一定是最终结果 */
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (res < dp[i])  res = dp[i];
        }
        return res + 1;
    }

    private boolean isPredecessor(String stra, String strb) {
        int i = 0;  // 字符串A的指针
        int j = 0;  // 字符串B的指针
        int lenA = stra.length();
        int lenB = strb.length();
        /* 排除长度相差不为一的情况 */
        if (lenA != lenB-1) {
            return false;
        }
        char[] a = stra.toCharArray();
        char[] b = strb.toCharArray();
        while (i < lenA && j < lenB) {
            if (a[i] == b[j]) {
                i++;
            }
            j++;
        }
        return i == lenA;
    }



    public static void main(String[] args) {
        LongestStringChain lsc  = new LongestStringChain();
        String[] array =  {"a","b","ba","bca","bda","bdca"};
        lsc.longestStrChain(array);
        lsc.longestStrChain2(array);

    }
}
