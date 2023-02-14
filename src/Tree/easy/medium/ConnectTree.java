package Tree.easy.medium;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class ConnectTree {
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        Queue <Node> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            int len = que.size();
            Node prev = null;
            while (len > 0){
                Node node = que.poll();
                if (prev == null){
                    node.next = null;
                }else {
                    node.next = prev;
                }
                if (node.right != null){
                    que.offer(node.right);
                }
                if (node.left != null){
                    que.offer(node.left);
                }
                prev = node;
                len--;
            }
        }
        return root;
    }
}
