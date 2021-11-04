package stack.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author gaoayang
 * create by gaoyang on 2020/7/30
 * https://leetcode-cn.com/problems/next-greater-element-i/
 */
public class NextGreaterElement {
    /**
     * 暴力解法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int j = 0; j < nums1.length; j++) {
            for (int i = 0; i < nums2.length; i++) {
                if (nums2[i] == nums1[j]) {
                    int k = i;
                    for (; k < nums2.length; k++) {
                        if (nums2[k] > nums2[i]) {
                            ans[j] = nums2[k];
                            break;
                        }
                    }
                    if (k == nums2.length) {
                        ans[j] = -1;
                    }
                    break;
                }
            }

        }
        return ans;
    }

    /**
     * 时间复杂度很低O(m+n)
     * 空间复杂度O(n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i <nums2.length ; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i <nums1.length ; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        NextGreaterElement object = new NextGreaterElement();
        object.nextGreaterElement2(nums1, nums2);
    }
}
