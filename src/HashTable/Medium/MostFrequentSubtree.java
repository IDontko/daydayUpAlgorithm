package HashTable.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by gaoyang on 2019/8/16
 */
public class MostFrequentSubtree {
    public int[] findFrequentTreeSum(TreeNode root) {
        int[] result = new int[3];
        int[] max = new int[1];
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<Integer>();
        caculateSum(root,map,max);
        for(int key :map.keySet()){
            if(map.get(key)==max[0]){
                    list.add(key);
            }
        }
        return toArray(list);
    }

    private int[] toArray(List<Integer> l) {
        int[] arr = new int[l.size()];
        for (int i = 0; i < l.size(); i++) arr[i] = l.get(i);
        return arr;
    }
    public int caculateSum(TreeNode node, Map<Integer,Integer> map,int[] max){
        if(node==null){
            return 0;
        }
        int left = caculateSum(node.left,map,max);
        int right = caculateSum(node.right,map,max);
        int nodeSum = left+right+node.val;
        map.put(nodeSum,map.getOrDefault(nodeSum,0)+1);
        max[0] = Math.max(max[0],map.get(nodeSum));
        return nodeSum;
    }
}
