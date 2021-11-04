package HashTable.Medium;


import java.util.*;

/**
 * create by gaoyang on 2019/7/29
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * class Solution {
 *     List<Location> locations;
 *     public List<List<Integer>> verticalTraversal(TreeNode root) {
 *         // Each location is a node's x position, y position, and value
 *         locations = new ArrayList();
 *         dfs(root, 0, 0);
 *         Collections.sort(locations);
 *
 *         List<List<Integer>> ans = new ArrayList();
 *         ans.add(new ArrayList<Integer>());
 *
 *         int prev = locations.get(0).x;
 *
 *         for (Location loc: locations) {
 *             // If the x value changed, it's part of a new report.
 *             if (loc.x != prev) {
 *                 prev = loc.x;
 *                 ans.add(new ArrayList<Integer>());
 *             }
 *
 *             // We always add the node's value to the latest report.
 *             ans.get(ans.size() - 1).add(loc.val);
 *         }
 *
 *         return ans;
 *     }
 *
 *     public void dfs(TreeNode node, int x, int y) {
 *         if (node != null) {
 *             locations.add(new Location(x, y, node.val));
 *             dfs(node.left, x-1, y+1);
 *             dfs(node.right, x+1, y+1);
 *         }
 *     }
 * }
 *
 * class Location implements Comparable<Location>{
 *     int x, y, val;
 *     Location(int x, int y, int val) {
 *         this.x = x;
 *         this.y = y;
 *         this.val = val;
 *     }
 *
 *     @Override
 *     public int compareTo(Location that) {
 *         if (this.x != that.x)
 *             return Integer.compare(this.x, that.x);
 *         else if (this.y != that.y)
 *             return Integer.compare(this.y, that.y);
 *         else
 *             return Integer.compare(this.val, that.val);
 *     }
 * }
 */
 class VerticalOrder {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int val = 0;
        List<Integer> tempList = new ArrayList<>();
        IdentityHashMap<Integer,TreeNode> maps = new IdentityHashMap<Integer,TreeNode>();
        if(root!=null){
            maps.put(val,root);
            this.lunxun(root,maps,val);
        }

        return new ArrayList<List<Integer>>();
    }

    public Map lunxun(TreeNode treeNode , IdentityHashMap<Integer,TreeNode> map,int val){
        TreeNode tempLeft ;
        TreeNode tempRight ;
        if(treeNode.left!=null){
            map.put(val--,treeNode.left);
            tempLeft = treeNode.left;
            this.lunxun(treeNode,map,val);
        }

        if(treeNode.right!=null){
            map.put(val++,treeNode.left);
            tempLeft = treeNode.left;
            this.lunxun(treeNode,map,val);
        }
        return map;
    }

    public static void main(String[] args) {

    }


}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

