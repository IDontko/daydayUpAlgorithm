package Tree.easy;

import java.util.*;

public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        while(!que.isEmpty()){

            double sum = 0;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                sum += node.val;
                if (node.left != null){
                    que.offer(node.left);
                }
                if (node.right != null){
                    que.offer(node.right);
                }
            }
            ans.add(sum/size);
        }
        return ans;
    }

}
