package stack.easy;

/**
 * @author gaoayang
 * create by gaoyang on 2020/7/17
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] < target) {
                continue;
            } else {
                return i;
            }
        }
        return i;
    }

    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid = (left + right) / 2;
        if (target < nums[left]){
            return left;
        }
        if (target > nums[right - 1]){
            return right;
        }
        while (nums[mid] != target) {
            if (right - left == 1) {
                mid = mid + 1;
                break;
            }
            if (target > nums[mid]) {
                left = mid;
            } else if (target < nums[mid]) {
                right = mid;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }

    public int searchInsert3(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int[] arr = {1, 3, 5, 6};
        int target = 0;
        System.out.println(searchInsert.searchInsert2(arr, target));

    }
}
