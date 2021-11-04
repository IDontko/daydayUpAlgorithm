package HashTable.Easy;


import javax.xml.stream.FactoryConfigurationError;
import java.util.*;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 * 目的：是要检查两个String字符串是不是同形的。
 * 思路： hashMap的key 对应 s字符串的字符，value对应 t字符串的字符。 循环 s 字符串，并放置对应的value。如果当前value存在并且不等于 t 要放置的值返回false 否则返回true
 */
public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hm = new HashMap<>();
        Set sean = new HashSet<Character>();
        char ss[] = s.toCharArray(), tt[] = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(ss[i])) {
                ss[i] = hm.get(ss[i]);
                if (ss[i] != tt[i]) return false;
            }
            else {
                if (!sean.add(tt[i])) return false;
                hm.put(ss[i], tt[i]);
                ss[i] = hm.get(ss[i]);
                sean.add(tt[i]);
            }
        }
        return Arrays.equals(ss, tt);
    }

    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        IsomorphicStrings.isIsomorphic(s,t);
    }
}

