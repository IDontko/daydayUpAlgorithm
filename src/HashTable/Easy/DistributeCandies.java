package HashTable.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/distribute-candies/
 * Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind.
 * You need to distribute these candies equally in number to brother and sister.
 * Return the maximum number of kinds of candies the sister could gain.
 * 分糖果，数组为偶数个，分为两份，要求其中一份的种类数是最多的。返回种类数。
 *
 */
public class DistributeCandies {
    public static int distributeCandies(int[] candies) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(Integer candy: candies){
            map.put(candy,map.getOrDefault(candy,0)+1);
        }
        if(candies.length/2<=map.size())
        {
            return candies.length/2;
        }
        return map.size();
    }

    public static void main(String[] args) {

        int[] candies ={1,1,2,2,3,3};
        int result = DistributeCandies.distributeCandies(candies);
        System.out.println(result);
    }
}
