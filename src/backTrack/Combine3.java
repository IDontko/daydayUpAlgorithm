package backTrack;

import java.util.*;

/**
 * 找出所有相加之和为,n 的,k,个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字,最多使用一次,
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combine3 {
    List<Integer> path;
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        combination(n, k,1);
        return ans;
    }

    private void combination(int n, int k, int startIndex){
        if (n < 0 || k < 0){
            return;
        }
        if (n == 0 && k != 0 ){
            return ;
        }
        if (n != 0 && k == 0){
            return;
        }
        if (n == 0 && k==0){
            ans.add(new ArrayList<>(path));
            return ;
        }
        for(int i = startIndex; i<=9 && n > i; i++){
            path.add(i);
            combination(n - i, k -1, startIndex + 1);
            path.remove(path.size() -1);
        }
    }

    public static void main(String[] args) {
            new Combine3().combinationSum3(3,7);
    }
}
