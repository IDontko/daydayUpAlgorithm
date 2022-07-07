package dailyExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gaoyang
 * create on 2022/7/4
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * <p>
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 */
public class MinAbsDiff {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int minSub = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int l = arr[i - 1];
            int r = arr[i];
            if (r - l < minSub){
                ans.clear();
                ans.add(Arrays.asList(l, r));
                minSub = r - l;
            }else if (r - l == minSub){
                ans.add(Arrays.asList(l, r));
            }
        }
        return ans;
    }
}
