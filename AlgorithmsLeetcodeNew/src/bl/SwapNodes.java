package bl;

/**
 * Created by Akshay Hegde on 4/13/2019.
 *
 * 24. Swap Nodes in Pairs
 Medium

 1023

 92

 Favorite

 Share
 Given a linked list, swap every two adjacent nodes and return its head.

 You may not modify the values in the list's nodes, only nodes itself may be changed.



 Example:

 Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode newHead = head.next;
        ListNode cur = head;
        ListNode next = cur.next;
        while(next!=null){
            ListNode temp = next.next;
            cur.next = temp;
            next.next = cur;
            next = cur;
            cur = temp;
            if(cur!=null) {
                if(cur.next!=null) {
                    next.next = cur.next;
                }
                next = cur.next;
            }
            else{
                next = null;
            }
        }
        return newHead;

    }
}
