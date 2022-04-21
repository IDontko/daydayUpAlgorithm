package Tree.easy;

/**
 * @author gaoyang
 * create on 2022/4/21
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
 * 寻找二叉树的祖先
 * 忒难了。。
 * 想不到这种递归方式
 */
public class LowestCommonAncestor2 {
    private TreeNode ancestor;
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ( (lson && rson) || ( (lson || rson) && (p.val == root.val || q.val == root.val))){
            ancestor = root;
        }
        return lson || rson || (p.val == root.val || q.val == root.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        this.dfs(root, p, q);
        return this.ancestor;
    }
}
