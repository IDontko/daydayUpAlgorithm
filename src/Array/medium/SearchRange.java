package Array.medium;

/**
 * @author gaoyang
 * create on 2022/4/6
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums.length == 0){
            return ans;
        }
        int low = 0;
        int high = nums.length;
        int mid = (high + low) /2 ;
        while(high - low > 1 && nums[mid] != target ){
            if (nums[mid] > target){
                high = mid;
                mid = (high + low) /2 ;
            }else if (nums[mid] < target){
                low = mid;
                mid = (high + low) /2 ;
            }
        }
        for (int i = mid;  i < nums.length && nums[i] == target; i++) {
            ans[1] = i;
        }
        for (int i = mid; i >= 0 && nums[i] == target  ; i --) {
            ans[0] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        SearchRange obj = new SearchRange();
        obj.searchRange(nums, target);
    }
}
