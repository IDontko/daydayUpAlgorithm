package HashTable.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 *https://leetcode.com/problems/find-the-difference/
 *
 */
public class FindTheDifference {
    public static char findTheDifference(String s, String t) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();

        int count = s.length();
        for(int i=0;i<count;i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int tCount = t.length();
        for(int j = 0;j<tCount;j++){
            char m = t.charAt(j);

            map.put(m,map.getOrDefault(m,0)-1);
            if(map.get(m)==-1){
                return m;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        FindTheDifference.findTheDifference(s,t);

    }
}
