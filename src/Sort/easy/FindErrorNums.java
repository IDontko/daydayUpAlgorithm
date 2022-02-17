package Sort.easy;

import java.util.Arrays;

public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        int lowbit = xor & (-xor);
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & lowbit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & lowbit) == 0) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }
        for (int num : nums) {
            if (num == num1) {
                return new int[]{num1, num2};
            }
        }
        return new int[]{num2, num1};
    }

    public int[] findErrorNums2(int[] nums){
        int[] ans = new int[2];
        int current = 0;
        int prev = -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i++) {
            current = nums[i];
            if (current == prev){
                ans[0] = current;
            } else if (current - prev > 1){
                ans[1] =  current - 1;
            }
            prev = current;
        }
        if (nums[nums.length - 1] != nums.length){
            ans[1] = nums.length;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4};
        FindErrorNums findErrorNums = new FindErrorNums();
        findErrorNums.findErrorNums2(nums);
    }
}
