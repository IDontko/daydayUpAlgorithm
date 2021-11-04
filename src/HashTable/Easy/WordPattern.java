package HashTable.Easy;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null || pattern.length() == 0 || str.length() == 0) {
            return false;
        }
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map1.containsKey(ch) && !map1.get(ch).equals(words[i])) {
                return false;
            } else if (map2.containsKey(words[i]) && map2.get(words[i]) != ch) {
                return false; // due to "bijection" requirement in problem
            }
            map1.put(ch, words[i]);
            map2.put(words[i], ch);
        }
        return true;
    }



    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
    }
}
