package Array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoyang
 * create on 2022/3/30
 * https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
 */
public class KweakestRow {
    public boolean checkIfExist(int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(int i: arr){
            if (i == 0 && map.get(0) >=2){
                return true;
            }else if (i != 0 && map.containsKey(i * 2)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        KweakestRow obj = new KweakestRow();
        int[] arr = {0, 0};
        obj.checkIfExist(arr);
        System.out.println(2<<3);
    }
}
