package HashTable.Easy;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/
 * 相同字母的异序词
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Map<Character,Integer> smap = new HashMap<Character, Integer>();
        for(int i= 0; i<sArray.length;i++){
            if(smap.containsKey(sArray[i])){
                smap.put(sArray[i],smap.get(sArray[i])+1);
            }else{
                smap.put(sArray[i],1);
            }
        }
        for(int j = 0;j<tArray.length;j++){
            if(!smap.containsKey(tArray[j])||smap.get(tArray[j])==0){
                return false;
            }else{
                smap.put(tArray[j],smap.get(tArray[j])-1);
            }
        }

        System.out.println("True");
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        ValidAnagram.isAnagram(s,t);
    }
}
