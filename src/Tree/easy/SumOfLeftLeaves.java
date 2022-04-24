package Tree.easy;

/**
 * @author gaoyang
 * create on 2022/4/22
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {

        int ans  = dfs(root, false);
        return ans;
    }

    public int dfs(TreeNode root, boolean leftFlag) {
        int ans = 0;
        if (root != null) {
            if (root.left == null && root.right == null && leftFlag) {
                ans += root.val;
            } else {
                ans += dfs(root.left, true);
                ans += dfs(root.right, false);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3, new TreeNode(2, null, null), null);
        new SumOfLeftLeaves().sumOfLeftLeaves(node);
    }

}
