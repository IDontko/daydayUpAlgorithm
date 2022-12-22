package dailyExcercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheckPowerOfThree {
    public boolean checkPowersOfThree(int n) {
        List<Integer> list = new ArrayList<>();
        for(int x = 1; x <= n; x *= 3)list.add(x);
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        for(int x : list){
            int size = q.size();
            while(size-- >= 1){
                int p = q.poll();
                if(p - x == 0)return true;
                q.offer(p);
                q.offer(p - x);
            }
        }
        return false;
    }

    public boolean checkPowersOfThree2(int n) {
        List<Integer> list = new ArrayList<>();
        for(int x = 1; x <= n; x *= 3)list.add(x);
        return postOrderSearch(list, 0, n);
    }

    /** 前序遍历*/
    private boolean preOrderSearch(List<Integer> list, int deep, int node){
        if(deep >= list.size())return node == 0;
        int left = node, right = node - list.get(deep);
        if(node == 0)return true;
        if(preOrderSearch(list, deep + 1, left))return true;
        return inOrderSearch(list, deep + 1, right);
    }

    /** 中序遍历*/
    private boolean inOrderSearch(List<Integer> list, int deep, int node){
        if(deep >= list.size())return node == 0;
        int left = node, right = node - list.get(deep);
        if(preOrderSearch(list, deep + 1, left))return true;
        if(node == 0)return true;
        return preOrderSearch(list, deep + 1, right);
    }

    /** 后序遍历*/
    private boolean postOrderSearch(List<Integer> list, int deep, int node){
        if(deep >= list.size())return node == 0;
        int left = node, right = node - list.get(deep);
        if(preOrderSearch(list, deep + 1, left))return true;
        if(preOrderSearch(list, deep + 1, right))return true;
        return node == 0;
    }


    public static void main(String[] args) {
        new CheckPowerOfThree().checkPowersOfThree2(12);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(3);
        System.out.println(queue.size());
    }
}
