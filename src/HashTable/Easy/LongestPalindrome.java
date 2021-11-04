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

    public static void main(String[] args) {
        /* output =7;
        Explanation:
        One longest palindrome that can be built is "dccaccd", whose length is 7.*/
        String s = "abccccdd";
        System.out.println(5/2*2);
    }
}
