package String.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author gaoyang
 * create on 2021/12/27
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.toCharArray().length; i++) {
            Integer count = map.get(t.charAt(i));
            if (count == null){
                return false;
            } else if (count > 1){
                map.put(t.charAt(i), count - 1);
            } else {
                map.remove(t.charAt(i));
            }
        }
        return true;
    }

    public boolean isAnagram4(String s, String t) {
        int[] counts = new int[26];
        t.chars().forEach(tc -> counts[tc - 'a']++);
        s.chars().forEach(cs -> counts[cs - 'a']--);
        return Arrays.stream(counts).allMatch(c -> c == 0);
    }

    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";
        Anagram anagram = new Anagram();
        anagram.isAnagram(s, t);
    }
}
