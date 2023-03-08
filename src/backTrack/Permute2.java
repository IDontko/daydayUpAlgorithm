package backTrack;

import java.util.ArrayList;
import java.util.List;

public class Permute2 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int n ;

    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        boolean[] used = new boolean[n];
        backTrack(nums, used);
        return ans;
    }

    public void backTrack(int[] nums, boolean[] used){
        if (path.size() == n){
            ans.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && (!used[i-1])){
                continue;
            }
            if (!used[i]){
                used[i] = true;
                path.add(nums[i]);
                backTrack(nums, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permute2 permute = new Permute2();
        int[] nums = {1,1,3};
        permute.permuteUnique(nums);
    }
}
