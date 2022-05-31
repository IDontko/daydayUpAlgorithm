package dataStructure.hard;

/**
 * @author gaoyang
 * create on 2022/5/4
 * https://leetcode-cn.com/problems/design-skiplist/solution/javashou-xie-shi-xian-tiao-biao-by-feng-omdm0/
 * 跳表实现
 */
public class SkipList {
    public static int DEFAULT_MAX_LEVEL = 32;

    public static double DEFAULT_P_FACTOR = 0.25;

    int currentIndex = 1;

    Node head  = new Node(null, DEFAULT_MAX_LEVEL);

    public void add(int num) {
        int level = randomLevel();
        Node newNode = new Node(num, level);
        Node updateNode = head;
        for (int i = currentIndex - 1; i > 0; i--) {
            updateNode = getClosestNode(updateNode, i, num);
            if (i < level){
                if (updateNode.next[i] == null){
                    updateNode.next[i] = newNode;
                }else {
                    Node temp = updateNode.next[i];
                    updateNode.next[i] = newNode;
                    newNode.next[i] = temp;
                }
            }
        }
    }

    private int randomLevel() {
        int level = 1;
        while (Math.random() < DEFAULT_P_FACTOR && level < DEFAULT_MAX_LEVEL) {
            level++;
        }
        return level;
    }

    private Node getClosestNode(Node node, int levelIndex, int value) {
        while (node.next[levelIndex] != null && value > node.next[levelIndex].value) {
            node = node.next[levelIndex];
        }
        return node;
    }

    class Node {

        //表示当前节点的值
        Integer value;

        //next表示跳表的层数
        Node[] next;

        public Node(Integer value, int size) {
            this.value = value;
            this.next = new Node[size];
        }
    }

}
