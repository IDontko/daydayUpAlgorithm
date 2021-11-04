package Array.easy;

/**
 * @author gaoyang
 * create on 2021/10/20
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = 0;
        int[] sorter = new int[m + n];
        int cur;
        while(left < m || right < n){
            if (left == m){
                cur = nums2[right++];
            }else if (right == n){
                cur = nums1[left++];
            }else if (nums1[left] < nums2[right]){
                cur = nums1[left++];
            }else{
                cur = nums2[right++];
            }
            sorter[left + right - 1] = cur;
        }
        for (int i = 0; i < m + n ; i++) {
            nums1[i] = sorter[i];
        }
    }

    public static void main(String[] args) {
        System.out.println(0.1 * 3 == 0.3);
    }
}
