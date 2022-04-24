package Tree.easy;

/**
 * @author gaoyang
 * create on 2022/4/24
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * 二叉搜索树找最小差值。说明差值最小就是父节点和子节点之间的差距。遍历树，然后算差值最小
 */
public class GetMinimumDifference {
    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

}
