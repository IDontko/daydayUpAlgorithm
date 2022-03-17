package Array.easy;

/**
 * @author gaoyang
 * create on 2022/3/2
 * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 * 给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回 true，否则返回 false。
 *
 * 形式上，如果可以找出索引 i + 1 < j 且满足 (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1]) 就可以将数组三等分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanThreePartsEqualSum {
    //思路错误
    public boolean canThreePartsEqualSum(int[] arr) {
        int length = arr.length;
        int i = 0;
        int j = length - 1;
        int sumLeft = 0;
        int sumRight = 0;
        while (i < j){
            if (i==0 || sumLeft <  sumRight){
                sumLeft += arr[i];
                i++;
            }else if (j == length - 1 || sumRight < sumLeft) {
                sumRight += arr[j];
                j--;
            //左边和右边和相同
            }else {
                int sumMid = 0;
                int mid = i;
                while (mid <= j){
                    sumMid += arr[mid];
                    mid++;
                }
                if (sumMid == sumLeft){
                    return true;
                }
                break;
            }
        }
        return false;
    }
    public boolean canThreePartsEqualSum2(int[] A) {
        int s = 0;
        for (int num : A) {
            s += num;
        }
        if (s % 3 != 0) {
            return false;
        }
        int target = s / 3;
        int n = A.length, i = 0, cur = 0;
        while (i < n) {
            cur += A[i];
            if (cur == target) {
                break;
            }
            ++i;
        }
        if (cur != target) {
            return false;
        }
        int j = i + 1;
        while (j + 1 < n) {  // 需要满足最后一个数组非空
            cur += A[j];
            if (cur == target * 2) {
                return true;
            }
            ++j;
        }
        return false;
    }



    public static void main(String[] args) {
        int[] arr  = {0,2,1,-6,6,7,9,-1,2,0,1};
        CanThreePartsEqualSum obj = new CanThreePartsEqualSum();
        obj.canThreePartsEqualSum(arr);

    }
}
