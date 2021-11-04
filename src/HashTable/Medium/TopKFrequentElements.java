package HashTable.Medium;

import java.util.*;

/**
 * create by gaoyang on 2019/8/13
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1)-map.get(n2));

        for(int n:map.keySet()){
            heap.add(n);
            if(heap.size()>k){
                heap.poll();
            }
        }
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }

    public static void main(String[] args) {

    }
}

