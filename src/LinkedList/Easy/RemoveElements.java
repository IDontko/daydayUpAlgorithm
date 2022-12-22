package LinkedList.Easy;
import common.ListNode;

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode( -1, head);
        ListNode prev =dummy;
        ListNode cur = head;
        while (cur != null){
            ListNode currNode = prev.next;
            if (currNode.val == val){
                prev.next = currNode.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }


        return dummy.next;
    }
}
