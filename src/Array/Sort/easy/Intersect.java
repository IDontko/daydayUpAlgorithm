package Array.Sort.easy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 *  
 *输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j= 0;
        while(i< nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if (nums1[i] > nums2[j]){
                j++;
            }else {
                i++;
            }
        }
        int[] result = new int[list.size()];
        for (int k = 0; k <list.size() ; k++) {
            result[k] = list.get(k);

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {1,1};
        Intersect object =new Intersect();
        object.intersect(nums1, nums2);
    }
}
