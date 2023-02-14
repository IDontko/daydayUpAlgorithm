package Tree.easy.medium;

import Tree.easy.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int ans  = 0;
        while (!que.isEmpty()){
            int len = que.size();
            while (len >0){
                TreeNode node = que.poll();
                ans++;
                if (node.left != null){
                    que.offer(node.left);
                }
                if (node.right != null){
                    que.offer(node.right);
                }
                len --;
            }
        }
        return ans;
    }

    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0; // 这里初始为0是有目的的，为了下面求指数方便
        while (left != null) {  // 求左子树深度
            left = left.left;
            leftDepth++;
        }
        while (right != null) { // 求右子树深度
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1; // 注意(2<<1) 相当于2^2，所以leftDepth初始为0
        }
        return countNodes(root.left) + countNodes(root.right) + 1;

    }
}
