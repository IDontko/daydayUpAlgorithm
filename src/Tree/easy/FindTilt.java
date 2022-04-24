package Tree.easy;

/**
 * @author gaoyang
 * create on 2022/4/24
 * https://leetcode-cn.com/problems/binary-tree-tilt/
 * 二叉树的坡度
 * 每个点的坡度计算，然后相加
 */
public class FindTilt {
    int ans;

    public int findTilt(TreeNode root) {
        sum(root);
        dfs(root);
        return ans;
    }

    public void sum(TreeNode root) {
        if (root == null) {
            return;
        }
        sum(root.left);
        sum(root.right);
        root.val = root.val + (root.left == null ? 0 : root.left.val) + (root.right == null ? 0 : root.right.val);

    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        if (root.left != null || root.right != null) {
            ans += Math.abs((root.left == null ? 0 : root.left.val) - (root.right == null ? 0 : root.right.val));
        }

    }

    public int findTilt2(TreeNode root) {
        dfs2(root);
        return ans;
    }

    public int dfs2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sumLeft = dfs2(node.left);
        int sumRight = dfs2(node.right);
        ans += Math.abs(sumLeft - sumRight);
        return sumLeft + sumRight + node.val;
    }



    public static void main(String[] args) {
        FindTilt t = new FindTilt();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(2, null, null), null), new TreeNode(3, null, null));
        t.findTilt(root);
        System.out.println("test");
    }
}
