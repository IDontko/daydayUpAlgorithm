package Tree.easy;

/**
  @author gaoyang
  create on 2022/4/20
**/
public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x){
        val = x;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
