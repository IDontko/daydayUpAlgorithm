package HashTable.Medium;

import java.util.*;

/**
 * create by gaoyang on 2019/9/9
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
        for(String word:words){
            hashMap.put(word,hashMap.getOrDefault(word,0)+1);
        }

        List<String> candidates = new ArrayList(hashMap.keySet());
        Collections.sort(candidates, (w1, w2) -> hashMap.get(w1).equals(hashMap.get(w2)) ?
                w1.compareTo(w2) : hashMap.get(w2) - hashMap.get(w1));

        return candidates.subList(0, k);
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};

    }
}
