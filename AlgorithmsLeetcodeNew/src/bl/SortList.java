package bl;

/**
 * Created by Akshay Hegde on 6/25/2019.
 *
 * Sort a linked list in O(n log n) time using constant space complexity.

 Example 1:

 Input: 4->2->1->3
 Output: 1->2->3->4
 Example 2:

 Input: -1->5->3->4->0
 Output: -1->0->3->4->5

 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pivot = new ListNode(head.val);
        ListNode leftHead = null;
        ListNode rightHead = null;
        ListNode left = null;
        ListNode right = null;
        ListNode track = head.next;
        while (track!=null){
            if(track.val<pivot.val){
                if(leftHead==null){
                    leftHead = new ListNode(track.val);
                    leftHead.next = null;
                    left = leftHead;
                }
                else {
                    left.next = new ListNode(track.val);
                    left = left.next;
                    left.next=null;
                }
            }
            else {
                if(rightHead==null){
                    rightHead = new ListNode(track.val);
                    rightHead.next = null;
                    right = rightHead;
                }
                else {
                    right.next = new ListNode(track.val);
                    right = right.next;
                    right.next=null;
                }
            }
            track = track.next;
        }
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        pivot.next = rightHead;
        if (leftHead==null){
            return pivot;
        }
        left = leftHead;
        while (left.next!=null){
            left = left.next;
        }
        left.next = pivot;
        return leftHead;

    }
}
