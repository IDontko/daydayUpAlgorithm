package greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 分发饼干
 * https://leetcode.cn/problems/assign-cookies/
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int i = g.length -1;
        int j = s.length -1;
        while (i >=0 && j>=0){
            if (s[j] >= g[i]){
                ans++;
                i--;
                j--;
            }else {
                i--;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        new FindContentChildren().findContentChildren(g, s);
    }
}
