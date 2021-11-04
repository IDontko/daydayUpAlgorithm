package HashTable.Medium;

import java.util.*;

/**
 * create by gaoyang on 2019/8/29
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs){
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }


    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat"};

    }
}
