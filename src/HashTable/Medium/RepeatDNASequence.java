package HashTable.Medium;

import java.util.*;

/**
 * create by gaoyang on 2019/9/19
 */
public class RepeatDNASequence {

    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() <= 10) return new ArrayList<>();

        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        for(int i = 0; i + 10 <= s.length(); ++i){
            String temp = s.substring(i,i+10);
            if(!set.add(temp)) result.add(temp);
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String s1 = "AAAAAAAAAA";
        RepeatDNASequence re = new RepeatDNASequence();
        re.findRepeatedDnaSequences(s);
    }
}
