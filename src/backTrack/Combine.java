package backTrack;

import java.util.*;

public class Combine {
    List<List<Integer>> ans ;
    List<Integer> path;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        backTracking(n, k, 1);
        return ans;
    }

    private void backTracking(int n, int k , int startIndex){
        if (path.size() == k){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex;i <=n ; i++){
            path.add(i);
            backTracking(n, k, i+1);
            path.remove(path.size() -1);
        }

        /*减枝优化
        for(int i = startIndex;i <=n - (k - path.size()); i++){
            path.add(i);
            backTracking(n, k, i+1);
            path.remove(path.size() -1);
        }
        * */
    }

    public static void main(String[] args) {
        new Combine().combine(4, 2);
    }
}
