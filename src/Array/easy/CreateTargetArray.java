package Array.easy;

import java.util.*;

/**
 * @author gaoyang
 * create on 2022/4/1
 * https://leetcode-cn.com/problems/create-target-array-in-the-given-order/
 */
public class CreateTargetArray {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<Integer>();
        Deque<Integer> deque = new LinkedList();

        for (int i = 0; i < nums.length; ++i) {
            list.add(index[i], nums[i]);
        }
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
