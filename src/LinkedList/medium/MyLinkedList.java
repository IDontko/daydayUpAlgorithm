package LinkedList.medium;

import common.ListNode;

public class MyLinkedList {

    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(-1);
    }

    public int get(int index) {
        if (index< 0 ||  index >= size ){
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size){
            return;
        }
        if (index < 0){
            index = 0;
        }
        size++;
        ListNode prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = prev.next;
        prev.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
            return;
        }
        ListNode pred = head;
        for (int i = 0; i < index ; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}
