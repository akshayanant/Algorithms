package bl;

/**
 * Created by Akshay Hegde on 5/24/2019.
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 Example 1:

 Input: 1->2->3->3->4->4->5
 Output: 1->2->5
 Example 2:

 Input: 1->1->1->2->3
 Output: 2->3

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class RemoveDuplicateSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead;
        ListNode node = head;
        int prev;
        int cur;
        int next;
        if(head.val!=head.next.val){
            newHead = new ListNode(head.val);
        }
        else {
            boolean found = false;
            while (true) {
                prev = node.val;
                if (node.next != null) {
                    cur = node.next.val;
                    if (node.next.next != null) {
                        next = node.next.next.val;
                    } else {
                        if (prev != cur) {
                            newHead = new ListNode(node.next.val);
                            newHead.next = null;
                            return newHead;
                        }
                        return null;
                    }
                } else {
                    return null;
                }
                if (prev != cur && cur != next) {
                    newHead = new ListNode(node.next.val);
                    newHead.next = null;
                    node = node.next;
                    break;
                }
                node = node.next;
            }
        }
            ListNode track = newHead;
            while (true){
                prev = node.val;
                if(node.next!=null){
                    cur = node.next.val;
                    if(node.next.next!=null){
                        next = node.next.next.val;
                    }
                    else{
                        if(cur!=prev){
                            ListNode newNode = new ListNode(node.next.val);
                            newNode.next = null;
                            track.next = newNode;
                            return newHead;
                        }
                        else{
                            return newHead;
                        }
                    }
                }
                else{
                    return newHead;
                }
                if(prev!=cur && cur!=next){
                    ListNode newNode = new ListNode(node.next.val);
                    newNode.next = null;
                    track.next = newNode;
                    track = track.next;
                }
                node = node.next;
            }
    }
}
