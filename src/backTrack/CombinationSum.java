package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {

    private List<List<Integer>> ans = new ArrayList<>();

    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        getPath(0, candidates, target, path, 0);
        return ans;
    }

    private void  getPath(int sum, int[] candidates, int target, List<Integer> path, int startIndex){
        if (sum > target){
            return;
        }
        if (sum == target){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            getPath(sum, candidates, target, path, i);
            sum -=  candidates[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates =  {2,3,6,7};
        new CombinationSum().combinationSum(candidates, 7);
    }
}
