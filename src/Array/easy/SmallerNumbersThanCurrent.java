package Array.easy;

/**
 * @author gaoyang
 * create on 2022/3/31
 */
public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sortArr = new int[101];
        for(int num: nums){
            sortArr[num]++;
        }
        int[] countArr = new int[101];
        int countPre = 0;
        for(int i = 0 ; i<101; i++){
            countArr[i] = countPre;
            countPre += sortArr[i];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = countArr[nums[i]];

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        SmallerNumbersThanCurrent current = new SmallerNumbersThanCurrent();
        current.smallerNumbersThanCurrent(nums);
    }
}
