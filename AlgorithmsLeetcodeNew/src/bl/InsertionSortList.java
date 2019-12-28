package bl;

import java.util.Stack;

/**
 * Created by Akshay Hegde on 6/25/2019.
 *
 * Sort a linked list using insertion sort.


 A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list


 Algorithm of Insertion Sort:

 Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 It repeats until no input elements remain.

 Example 1:

 Input: 4->2->1->3
 Output: 1->2->3->4
 Example 2:

 Input: -1->5->3->4->0
 Output: -1->0->3->4->5


 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
        ListNode track = head.next;
        while (track!=null){
            ListNode sorted = track.next;
            if(stack.peek().val>track.val) {
                stack.peek().next = track.next;
                ListNode next = stack.pop();
                while (!stack.isEmpty() && stack.peek().val > track.val) {
                    next = stack.pop();
                }
                if (stack.isEmpty()) {
                    track.next = head;
                    head = track;
                } else {
                    stack.peek().next = track;
                    track.next = next;
                }
            }
            if(sorted==null){
                break;
            }
            ListNode fillStack = track;
            while (!fillStack.equals(sorted)){
                stack.push(fillStack);
                fillStack = fillStack.next;
            }
            track = sorted;
        }
        return head;
    }

    private ListNode solution2(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead = new ListNode(head.val);
        newHead.next = null;
        head = head.next;
        while (head!=null){
            newHead = insert(newHead,head);
            head = head.next;
        }
        return newHead;
    }

    private ListNode insert(ListNode head,ListNode oldNode){
        ListNode node = new ListNode(oldNode.val);
        if(head.val>=node.val){
            node.next = head;
            return node;
        }
        ListNode track = head.next;
        ListNode prev = head;
        while (track!=null&&track.val<node.val){
            prev = track;
            track = track.next;
        }
        prev.next = node;
        node.next = track;
        return head;
    }
}
