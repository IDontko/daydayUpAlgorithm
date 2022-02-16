package Array.easy;

/**
 * @author gaoyang
 * create on 2022/2/14
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 */
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                count++;
                maxLen = Math.max(maxLen, count);
            }else {
                count = 0;
            }
            
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        FindMaxConsecutiveOnes object = new FindMaxConsecutiveOnes();
        object.findMaxConsecutiveOnes(nums);

    }
}
