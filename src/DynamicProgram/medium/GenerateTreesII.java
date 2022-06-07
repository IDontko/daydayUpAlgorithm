package DynamicProgram.medium;

import stack.medium.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyang
 * create on 2022/5/31
 * https://leetcode.cn/problems/unique-binary-search-trees-ii/
 */
public class GenerateTreesII {

    //使用递归的方法的方法进行求解
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            //获取可能的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            //获取可能的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            //从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees){
                for (TreeNode right : rightTrees){
                    TreeNode node = new TreeNode(i, left, right);
                    allTrees.add(node);
                }
            }
        }
        return allTrees;
    }

}
