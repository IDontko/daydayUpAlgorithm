package Tree.easy;

/**
 * @author gaoyang
 * create on 2022/4/20
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
