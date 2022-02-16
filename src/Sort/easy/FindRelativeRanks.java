package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 相对名次
 * https://leetcode-cn.com/problems/relative-ranks/
 *
 */
public class FindRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];
        int[] copyScore = Arrays.copyOf(score, score.length);
        Arrays.sort(copyScore);
        HashMap<Integer, Integer> sortMap = new HashMap<>();
        for (int i = 0; i <copyScore.length ; i++) {
            sortMap.put(copyScore[i],copyScore.length - i);
        }
        for (int i = 0; i < score.length ; i++) {
            if (sortMap.get(score[i]) == 1){
                result[i] = "Gold Medal";
            }else if (sortMap.get(score[i]) == 2){
                result[i] = "Silver Medal";
            }else if (sortMap.get(score[i]) == 3){
                result[i] = "Bronze Medal";
            }else {
                result[i] = sortMap.get(score[i]).toString();
            }

        }
        return result;
    }
    public String[] findRelativeRanks2(int[] score) {
        int n = score.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) {
            if (i >= 3) {
                ans[arr[i][1]] = Integer.toString(i + 1);
            } else {
                ans[arr[i][1]] = desc[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10,3,8,9,4};
        FindRelativeRanks object =new FindRelativeRanks();
        object.findRelativeRanks2(nums);
    }
}
