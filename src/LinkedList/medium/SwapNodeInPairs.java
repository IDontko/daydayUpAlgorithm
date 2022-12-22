package LinkedList.medium;

import common.ListNode;

/**
 * . 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 */
public class SwapNodeInPairs {

    public ListNode swapNodeINPairs(ListNode head){
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode temp = prev;
        while(temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next =  node2.next;
            node2.next = node1;
            temp = node1;
        }
        return prev.next;
    }
}
