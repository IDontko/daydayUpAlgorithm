package Array.easy;

/**
 * @author gaoyang
 * create on 2022/2/18
 * https://leetcode-cn.com/problems/find-pivot-index/
 */
public class PivotIndex {

    public int pivotIndex(int[] nums) {
       int total = 0;
        for (int i = 0; i < nums.length ; i++) {
            total += nums[i];
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total){
                return  i;
            }
            sum+=nums[i];
        }
        return -1;
    }
}
