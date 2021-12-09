package HashTable.Easy;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {

    public static boolean isHappy(int n) {
        while (true){
            int sum = 0;
            while(n>0){
                int y = n%10;
                sum += y*y;
                n /= 10;
            }
            //System.out.println(sum);
            if (sum==1)
                return true;
            else if (sum==4)
                return false;
            else
                return isHappy(sum);
        }
    }
    public static void main(String[] args) {
        int n = 19;
        System.out.println(HappyNumber.isHappy(n));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int i = 0; i< nums.length; i++){
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

}
