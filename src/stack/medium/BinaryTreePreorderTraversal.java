package stack.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gaoayang
 * create by gaoyang on 2020/8/27
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null){
                stack.add(node.right);
            }
            if (node.left != null){
                stack.add(node.left);
            }
        }

        return output;
    }
}
