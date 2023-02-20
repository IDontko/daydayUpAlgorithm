package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDup {

    private List<List<Integer>> ans = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        backTrack(0,nums);
        return ans;
    }

    private void backTrack(int startIndex, int[] nums){
        ans.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i-1] == nums[i]){
                continue;
            }
            path.add(nums[i]);
            backTrack(i  + 1 , nums);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[]  arr = {1,2,2};
        new SubsetsWithDup().subsetsWithDup(arr);
    }
}
