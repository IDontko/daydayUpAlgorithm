package DynamicProgram.medium;

import java.util.*;

/**
 * @author gaoyang
 * create on 2022/5/7
 * https://leetcode.cn/problems/minimum-genetic-mutation/
 * 最小基因变化
 */
public class MinMutation {
    static char[] items = new char[]{'A', 'C', 'G', 'T'};
    public int minMutation(String S, String T, String[] bank) {
        Set<String> set = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }
        Deque<String> d = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        d.addLast(S);
        map.put(S, 0);
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                String s = d.pollFirst();
                char[] cs = s.toCharArray();
                int step = map.get(s);
                for (int i = 0; i < 8; i++) {
                    for (char c : items) {
                        if (cs[i] == c){
                            continue;
                        }
                        char[] clone = cs.clone();
                        clone[i] = c;
                        String sub = String.valueOf(clone);
                        if (!set.contains(sub)) continue;
                        if (map.containsKey(sub)) continue;
                        if (sub.equals(T)) return step + 1;
                        map.put(sub, step + 1);
                        d.addLast(sub);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new MinMutation().minMutation("AACCGGTT", "AAACGGTA",  new String[]{ "AACCGGTA","AACCGCTA","AAACGGTA"});
    }


}
