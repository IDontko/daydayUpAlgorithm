package HashTable.Medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by gaoyang on 2019/9/5
 * https://leetcode.com/problems/brick-wall/
 */
public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        if(n == 0)
            return 0;
        if(n == 1){
            if(wall.get(0).size() == 1)
                return 1;
            return 0;
        }
        Map<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i = 0;i<wall.size();i++){
            int sum = 0 ;
            for(int j = 0; j<wall.get(i).size();j++){
                int value = wall.get(i).get(j);
                sum += value;
                hashMap.put(sum,hashMap.getOrDefault(value,0)+1);
            }
        }
        System.out.println(hashMap.toString());
        int result = 0 ;
        for(Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
            result = Math.max(entry.getValue(),result);
        }
        System.out.println(result);
        return wall.size()-result;
    }


    public int leastBricks2(List<List<Integer>> wall) {
        int n = wall.size();
        if(n == 0)
            return 0;
        if(n == 1){
            if(wall.get(0).size() == 1)
                return 1;
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int curr = 0;
        int num;
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < wall.get(i).size(); j++){
                if(j == 0){
                    curr = wall.get(i).get(j);
                }
                else{
                    curr = curr + wall.get(i).get(j);
                }
                num = map.getOrDefault(curr, 0) + 1;
                map.put(curr, num);
                if(j != wall.get(i).size() - 1)
                    cnt = Math.max(cnt, num);
            }
        }

        return n - cnt;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        int result = 0;
        for(int i =0 ;i<nums.length;i++){
            result =+ nums[i];
            System.out.println(result);
        }
    }
}
