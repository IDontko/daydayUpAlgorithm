package PrefixSum.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyang
 * create on 2022/6/28
 * https://leetcode.cn/problems/can-make-palindrome-from-substring/
 * 构建回文串检测
 */
public class CanMakePaliQueries {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        int cur = 0;
        int[] states = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cur ^= (1 << (s.charAt(i) - 'a'));
            states[i] = cur;
        }
        for (int i = 0; i < queries.length; i++) {
            int ostate = queries[i][0] > 0 ? states[queries[i][0] - 1] : 0;
            int state = ostate ^ states[queries[i][1]];
            int cnt = 0;
            while (state != 0) {
                if ((state & 1) == 1) cnt++;
                state >>= 1;
            }
            System.out.println(cnt);
            result.add(cnt / 2 <= queries[i][2]);
        }
        return result;

    }
    public static void main(String[] args) {
        CanMakePaliQueries obj = new CanMakePaliQueries();
        int[][] queries = {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        obj.canMakePaliQueries("abcda", queries);
    }
}


/*
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int k = queries[i][2];
            boolean result = isPalindrome(s.substring(left, right + 1), k);
            list.add(result);
        }
        return list;
    }

    public boolean isPalindrome(String target, int k){
        int start = 0;
        int end = target.length() - 1;
        while (start < end){
            if (target.charAt(start) == target.charAt(end)){
                start++;
                end--;
            }else if (k > 0) {
                k--;
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }

    */


