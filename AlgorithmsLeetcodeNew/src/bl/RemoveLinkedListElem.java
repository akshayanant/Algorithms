package bl;

/**
 * Created by Akshay Hegde on 8/21/2019.
 *
 * Remove all elements from a linked list of integers that have value val.

 Example:

 Input:  1->2->6->3->4->5->6, val = 6
 Output: 1->2->3->4->5

 */
public class RemoveLinkedListElem {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode track = head.next;
        ListNode prev = head;
        while (track!=null){
            if (track.val == val) {
                prev.next = track.next;
            }
            else{
                prev = prev.next;
            }
            track = track.next;
        }
        if(head.val==val){
            head = head.next;
        }
        return head;
    }
}

