package backTrack;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    List<List<Integer>> ans = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    int n ;
    public List<List<Integer>> permute(int[] nums){
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
            if (!used[i]){
                used[i] = true;
                path.add(nums[i]);
                backTrack(nums, used);
                used[i] = false;
                path.remove(path.size() -1 );
            }
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] nums = {1,2,3};
        permute.permute(nums);
    }
}

