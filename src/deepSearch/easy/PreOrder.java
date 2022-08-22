package deepSearch.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyang
 * create on 2022/8/22
 */
public class PreOrder {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null){
            return null;
        }
        ans.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            Node children = root.children.get(i);
            if (children == null){
                break;
            }
            preorder(children);
        }
        return ans;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
