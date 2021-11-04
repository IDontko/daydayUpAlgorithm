package HashTable.Easy;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/set-mismatch/
 */
public class Mismatch {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int dup = -1, missing = 1;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2)
                    dup = i;
            } else
                missing = i;
        }
        return new int[]{dup, missing};
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
    }
}
