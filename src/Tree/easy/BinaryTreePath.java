package Tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyang
 * create on 2022/4/22
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 */
public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root){
        List<String> ans = new ArrayList<>();
        this.dfs(ans, "", root);
        return ans;
    }
    public List<String> dfs(List<String> ans, String path, TreeNode node){
         if (node != null){
             StringBuffer pathSb = new StringBuffer(path);
             pathSb.append(Integer.toString(node.val));
             if (node.left == null && node.right == null){
                 ans.add(pathSb.toString());
             }else {
                 pathSb.append("->");
                 dfs(ans, pathSb.toString(), node.left);
                 dfs(ans, pathSb.toString(), node.right);
             }
         }
         return ans;
    }
}
