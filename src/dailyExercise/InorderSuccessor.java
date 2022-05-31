package dailyExercise;

import stack.medium.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyang
 * create on 2022/5/16
 */
public class InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> res = new ArrayList<>();
        dfs(root, res);
        int target = -1;
        for (int i = 0; i < res.size(); i++) {
            TreeNode treeNode = res.get(i);
            if (p == treeNode) {
                target = i + 1;
                break;
            }
        }
        if (target < res.size()) {
            return res.get(target);
        }
        return null;
    }

    private void dfs(TreeNode node, List<TreeNode> res) {
        if (node == null) {
            return;
        } else {
            dfs(node.left, res);
            res.add(node);
            dfs(node.right, res);
        }
    }
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        if (p.right != null) {
            successor = p.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.val > p.val) {
                successor = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return successor;
    }

}
