package dataStructure.easy;

import java.util.HashMap;

/**
 * @author gaoyang
 * create on 2022/3/16
 * 手动实现LRU (latest Recently Used)
 */
public class LRUCache {
    Node head, tail;
    //hash表容量
    int m;
    public HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        m = capacity;
        map = new HashMap<>(capacity);
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.r = tail;
        tail.l = head;
    }

    class Node {
        int k, v;
        Node l, r;

        public Node(int _k, int _v) {
            k = _k;
            v = _v;
        }
    }

    /**
     * 获取新节点
     * @param key
     * @return
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            refresh(node);
             return node.v;
        }
        return -1;
    }

    /**
     * 插入新节点
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        Node node;
        //如果队列中存在，则先删除表中节点再插入头节点
        if (map.containsKey(key)) {
            node = map.get(key);
            node.v = value;
        }else {
            if (map.size() == m){
                Node del = tail.l;
                map.remove(del.k);
                delete(del);
            }
            node = new Node(key,value);
            map.put(key, node);
        }
        refresh(node);
    }


    /**
     * 将节点插入头部
     * @param node
     */
    public void refresh(Node node){
        delete(node);
        node.l = head;
        node.r = head.r;
        head.r.l = node;
        head.r = node;

    }

    /**
     * 删除旧节点
     * @param node
     */
    public void delete(Node node) {
        if (node.l != null) {
            Node left = node.l;
            node.r = left.r;
            node.r.l = left;
        }
    }
}
