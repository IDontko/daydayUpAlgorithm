package HashTable.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * create by gaoyang on 2019/8/9
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<Object> stack = new Stack<Object>();
        List<Integer> list = new ArrayList<Integer>();
        TreeNode node = root ;
        while(node!=null || !stack.empty()){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
            if(!stack.empty()){
                node = (TreeNode) stack.peek();
                list.add(node.val);
                stack.pop();
                node = node.right;
            }
        }


        return list;
    }

    public static void main(String[] args) {

    }


}

