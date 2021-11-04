package stack.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gaoayang
 * create by gaoyang on 2020/8/25
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 二叉树锯齿形层次遍历
 */
public class ZigZagLevelOrderTraversal {

    /**
     * BFS
     *
     * @param root
     * @return 广度遍历的方式
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        nodeList.add(null);

        LinkedList<Integer> levelList = new LinkedList<>();

        //是否从左边开始
        boolean isLeft = true;
        while (nodeList.size() > 0) {
            TreeNode node = nodeList.pollFirst();
            if (node != null) {
                if (isLeft) {
                    levelList.addLast(node.val);
                } else {
                    levelList.addFirst(node.val);
                }
                if (node.left != null) {
                    nodeList.addLast(node.left);
                }
                if (node.right != null) {
                    nodeList.addLast(node.right);
                }

            } else {
                result.add(levelList);
                levelList = new LinkedList<>();
                if (nodeList.size() > 0) {
                    nodeList.addLast(null);
                }
                isLeft = !isLeft;

            }
        }
        return result;
    }

    protected void DFS(TreeNode node, int level, List<List<Integer>> results) {
        if (level >= results.size()) {
            LinkedList<Integer> newLevel = new LinkedList<Integer>();
            newLevel.add(node.val);
            results.add(newLevel);
        } else {
            if (level % 2 == 0) {
                results.get(level).add(node.val);
            } else {
                results.get(level).add(0, node.val);
            }
        }

        if (node.left != null) {
            DFS(node.left, level + 1, results);
        }
        if (node.right != null) {
            DFS(node.right, level + 1, results);
        }
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        DFS(root, 0, results);
        return results;
    }

}
