package Array.easy;

/**
 * @author gaoyang
 * create on 2021/9/15
 */
public class RemoveDuplicats {

    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     * 移除重复的项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        int fast = 1;
        int low = 1;
        while (fast < n){
            if (nums[fast] != nums[fast-1]){
                nums[low] = nums[fast];
                ++low;
            }
            ++fast;
        }
        return low;
    }


    /**
     * https://leetcode-cn.com/problems/remove-element/
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        int low = 0;
        int fast = 0;
        while (fast < n){
            if (nums[fast] != val){
                nums[low] = nums[fast];
                ++low;
            }
            ++fast;
        }
        return low;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        RemoveDuplicats rm =  new RemoveDuplicats();
        rm.removeDuplicates(nums);
//        rm.removeElement2(nums, val);
    }
}
