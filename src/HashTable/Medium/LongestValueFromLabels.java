package HashTable.Medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
public class LongestValueFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int[][] nums=new int[values.length][2];
        for(int i=0;i<values.length;i++) {
            nums[i][0]=values[i];
            nums[i][1]=labels[i];
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[0]-a[0];
            }
        });
        int res=0;
        int[] used=new int[20001];
        for(int i=0;i<nums.length;i++) {
            if(used[nums[i][1]]<use_limit) {
                used[nums[i][1]]++;
                num_wanted--;
                res+=nums[i][0];
            }
            if(num_wanted==0) return res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] values = {5,4,3,2,1};
        int[] lables = {1,1,2,2,3};
        int num_wanted = 3;
        int use_limit = 1;
    }
}
