package bl;

import java.util.Stack;

/**
 * Created by Akshay Hegde on 8/21/2019.
 *
 * Reverse a singly linked list.

 Example:

 Input: 1->2->3->4->5->NULL
 Output: 5->4->3->2->1->NULL
 Follow up:

 A linked list can be reversed either iteratively or recursively. Could you implement both?

 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        head.next = null;
        ListNode track = head;
        while (!stack.isEmpty()){
            track.next = stack.pop();
            track = track.next;
            track.next = null;
        }
        return head;
    }

    private ListNode iter(ListNode head){
        if(head==null){
            return null;
        }
        ListNode prev = null;
        ListNode track = head;
        ListNode temp;
        while (track!=null){
            temp = track.next;
            track.next = prev;
            prev = track;
            track = temp;
        }
        return prev;
    }
}
