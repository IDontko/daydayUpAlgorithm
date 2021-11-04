package stack.medium;

import java.util.LinkedList;

/**
 * @author gaoayang
 * create by gaoyang on 2020/9/1
 */
public class BSTIterator {

    private LinkedList<Integer> linkedList = new LinkedList<>();

    private int index;

    public BSTIterator(TreeNode root) {
        inorder(root);
        index = -1;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return this.linkedList.get(++this.index);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.index + 1 < this.linkedList.size();
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        linkedList.addLast(node.val);
        inorder(node.right);
    }
}
