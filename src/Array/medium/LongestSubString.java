package Array.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author gaoyang
 * create on 2021/8/16
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * eg : "abcabcbb" return 3
 * "dvdf" return 3
 * "pwwkew" return 3
 * ""tmmzuxt"' return 5
 */
public class LongestSubString {


    //错误思路1
    public int lengthOfLongestSubstringError1(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }

        char[] charArray = s.toCharArray();
        int result = 0;
        int start = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < charArray.length; i++) {
            if (set.contains(charArray[i])) {
                set.remove(charArray[i]);
            }
            set.add(charArray[i]);
//            result = Math.max(map.size(), result);
        }
        return result;
    }

    //错误思路2  下标问题 太烦了。
    public int lengthOfLongestSubstringError2(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        int result = 0;
        int start = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            if (hashMap.containsKey(charArray[i]) && start < hashMap.get(charArray[i])) {
                start = hashMap.get(charArray[i]);
            }
            hashMap.put(charArray[i], i);
            result = Math.max(result, start == 0 ? i - start + 1 : i - start);
//            result = Math.max(map.size(), result);
        }
        return result;
    }

    //正确思路 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        //记录字符串是否在set中保存过
        Set<Character> set = new HashSet<>();
        int n = s.length();
        //右指针标记， 刚开始还没移动的时候在左边界的左侧。
        int rk = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                //左指针移动一次，set中移除一个元素
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                //移动右指针
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);

        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubString object = new LongestSubString();
//        System.out.println(object.lengthOfLongestSubstring2("abcabcbb"));
    }
}
