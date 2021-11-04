package LinkedList.Easy;

import java.util.*;

/**
 * create by gaoyang on 2019/9/20
 */
public class MiddleLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode listNode = null;
        List<Integer> list = new LinkedList<Integer>();
        listNode = head;
        while(listNode.next!=null){
            list.add(listNode.val);
            listNode = listNode.next;
        }

        return listNode;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }



    public void deleteNode(ListNode node) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode nn = new ListNode(0);
        addNode(nn, l1, l2);
        return nn.next;
    }

    private ListNode addNode(ListNode nn, ListNode l1, ListNode l2) {
        if(l1 == null) { nn.next = l2; return nn; }
        if(l2 == null) { nn.next = l1; return nn; }
        if (l2.val < l1.val) {
            nn.next = l2;
            return addNode(nn.next, l1, l2.next);
        } else {
            nn.next = l1;
            return addNode(nn.next, l1.next, l2);
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        System.out.println(current.toString());
        System.out.println(head.toString());
        while (current != null && current.next != null) {
            System.out.println(head.val);
            System.out.println(current.val);
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public boolean hasCycle(ListNode head) {
        return false;
    }

    public boolean isPalindrome(ListNode head) {
        
        return false;
    }


    public static void main(String[] args) {
        String a = "abc";
        String b = a;

        System.out.println(a.equals(b));
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}