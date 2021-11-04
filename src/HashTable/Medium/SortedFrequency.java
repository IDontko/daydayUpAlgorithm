package HashTable.Medium;

import java.util.*;

/**
 * create by gaoyang on 2019/8/12
 */
public class SortedFrequency {
    public String frequencySort(String s) {
        char[] chArray = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char ch : chArray){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        String result="";
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> arg0,
                               Map.Entry<Character, Integer> arg1) {
                return arg1.getValue() - arg0.getValue();
            }
        });
        for(int i=0;i<list.size();i++){
            for(int j =0;j<list.get(i).getValue();j++) {
                result += list.get(i).getKey();
                System.out.println(result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "tree";
        SortedFrequency sortedFrequency = new SortedFrequency();
        sortedFrequency.frequencySort(s);
    }
}
