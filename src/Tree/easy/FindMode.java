package Tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyang
 * create on 2022/4/22
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * <p>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * <p>
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMode {

    //当前值个数
    int count;
    //当前遍历中最大个数
    int maxcount;
    //当前值
    int base;

    List<Integer> ans = new ArrayList<>();

    //思路： 中序遍历
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            mode[i] = ans.get(i);
        }
        return mode;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    private void update(int val) {
        if (val == base) {
            count++;
        } else {
            count = 1;
            base = val;
        }
        if (count == maxcount) {
            ans.add(val);
        }
        if (count > maxcount) {
            maxcount = count;
            ans.clear();
            ans.add(val);
        }
    }

    public static void main(String[] args) {
        int a = 5;
        System.out.println();
    }



}
