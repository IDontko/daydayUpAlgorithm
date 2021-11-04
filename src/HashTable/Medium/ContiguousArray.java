package HashTable.Medium;

import java.util.HashMap;

/**
 * create by gaoyang on 2019/9/12
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int ans = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i <nums.length ; i++) {
            nums[i] = nums[i]>0?1:-1;
            count += nums[i];
            if(map.containsKey(count)){
                ans = Math.max(ans,i-map.get(count));
            }else {
                map.put(count,i);
            }

        }
        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0};
        ContiguousArray contiguousArray = new ContiguousArray();
        contiguousArray.findMaxLength(nums);
    }
}
