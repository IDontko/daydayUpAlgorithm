package stack.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author gaoayang
 * create by gaoyang on 2020/8/21
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

    //中序遍历  左中右
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.isEmpty()){
            while(tmp != null){
                stack.push(tmp);
                tmp = tmp.left;
            }
            tmp = stack.pop();
            result.add(tmp.val);
            tmp = tmp.right;
        }
        return result;
    }

    // 后续遍历 左右中
    public  static  List<Integer> afterOrderTtaverSal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack  = new Stack<>();
        TreeNode tmp = root;
        TreeNode prev = null;
        while(tmp != null || !stack.isEmpty()){
            while(tmp != null){
                stack.push(tmp);
                tmp = tmp.left;
            }
            tmp = stack.pop();
            if (tmp.right == null || tmp.right == prev){
                result.add(tmp.val);
                prev = tmp;
                tmp = null;
            }else {
                stack.push(tmp);
                tmp = tmp.right;
            }

        }
        System.out.println(Arrays.toString(result.toArray()));
        return result;

    }

    public static void main(String[] args) {
        TreeNode leaf1 = new TreeNode(3, null , null);
        TreeNode leaf2 = new TreeNode(2, leaf1 , null);
        TreeNode node = new TreeNode(1, null ,leaf2);
        afterOrderTtaverSal(node);

    }
    
}
