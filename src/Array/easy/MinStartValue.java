package Array.easy;

import stack.medium.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author gaoyang
 * create on 2022/3/9
 */
public class MinStartValue {

    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(sum, min);
        }
        if (min >= 1) {
            return 1;
        } else {
            return 1 - min;
        }

    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] coverarray = new int[51];
        for (int[] array : ranges) {
            int l = array[0];
            int r = array[1];
            for (int i = l; i <= r; i++) {
                coverarray[i] = 1;
            }
        }
        for (int j = left; j <= right; j++) {
            if (coverarray[j] != 1) {
                return false;
            }
        }
        return true;
    }

    public int findMiddleIndex(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 0;
        }
        int[] sumLeft = new int[length + 1];
        int[] sumRight = new int[length + 1];
        sumLeft[0] = 0;
        sumRight[length] = 0;
        for (int i = 0; i < nums.length; i++) {
            sumLeft[i + 1] = sumLeft[i] + nums[i];
        }
        for (int j = length - 1; j >= 0; j--) {
            sumRight[j] = sumRight[j + 1] + nums[j];
        }
        for (int i = 0; i < length; i++) {
            if (sumLeft[i] == sumRight[i + 1]){
                return i;
            }
        }
        return -1;
    }

    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.pollLast();
            if (treeNode != null){
                swap(treeNode);
                if (treeNode.left != null){
                    queue.addLast(treeNode.left);
                }
                if (treeNode.right != null){
                    queue.addLast(treeNode.right);
                }
            }
        }
        return root;
    }

    public void swap(TreeNode root){
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public static void main(String[] args) {
/*        int[][] ranges = {{1, 2}, {3, 4}, {5, 6}};
        int[] nums = {1,-1,4};
        int left = 2;
        int right = 5;
        MinStartValue min = new MinStartValue();
        min.findMiddleIndex(nums);
//        min.isCovered(ranges, left, right);
//        int[] nums = {-3, 2, -3, 4, 2};
        min.minStartValue(nums);*/

        System.out.println(4 & 1);
    }
}
