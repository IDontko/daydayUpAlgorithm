package HashTable.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-palindrome/
 * 找出最长的回文结构
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }

    public String longestPalindrome2(String s) {
        int length = s.toCharArray().length;
        Boolean[][] dp = new Boolean[length][length];
        for(int i = 0; i< dp.length ; i++){
            dp[i][i] = true;
        }
        int maxlength = 0;
        String result = String.valueOf(s.charAt(0));
        for(int l = 2; l <= length; l++){
            for(int i = 0; i< length; i++){
                int j = i + l -1;
                if (j >= length){
                    break;
                }
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if (j - i< 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }

                }
                if (dp[i][j] && l >maxlength){
                    maxlength = l;
                    result =  s.substring(i, i + l);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /* output =7;
        Explanation:
        One longest palindrome that can be built is "dccaccd", whose length is 7.*/
        String s ="aacabdkacaa";
        System.out.println(5/2*2);
        new LongestPalindrome().longestPalindrome2(s);
    }
}
