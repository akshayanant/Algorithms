package bl;

import java.util.Stack;

/**
 * Created by Akshay Hegde on 6/21/2019.
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You may not modify the values in the list's nodes, only nodes itself may be changed.

 Example 1:

 Given 1->2->3->4, reorder it to 1->4->2->3.
 Example 2:

 Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null){
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode track = head.next;
        while (track!=null){
            stack.push(track);
            track = track.next;
        }
        while (!(head.next.equals(stack.peek())||head.equals(stack.peek()))){
            track = head.next;
            head.next = stack.pop();
            head = head.next;
            head.next = track;
            head = head.next;
        }
        if(head.next.equals(stack.peek())) {
            head.next = stack.pop();
            head = head.next;
        }
        head.next = null;
    }
}

