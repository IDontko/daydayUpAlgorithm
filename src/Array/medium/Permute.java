package Array.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gaoyang
 * create on 2022/4/8
 * https://leetcode-cn.com/problems/permutations/
 * 回溯法对于数组全排列
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        dfs(0, deque, ans, nums, used);
        return ans;
    }

    public void dfs(int depth, Deque<Integer> deque, List<List<Integer>> ans, int[] nums, boolean[] used){
        if (depth == nums.length){
            ans.add(new ArrayList<>(deque));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                used[i] = true;
                deque.addLast(nums[i]);
                dfs(depth+1, deque, ans, nums, used);
                used[i] = false;
                deque.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permute permute = new Permute();
        permute.permute(nums);
    }

}
