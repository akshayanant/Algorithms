package bl;

/**
 * Created by Akshay Hegde on 5/26/2019.
 *
 * Reverse a linked list from position m to n. Do it in one-pass.

 Note: 1 ≤ m ≤ n ≤ length of list.

 Example:

 Input: 1->2->3->4->5->NULL, m = 2, n = 4
 Output: 1->4->3->2->5->NULL

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class ReverseList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null||m==n){
            return head;
        }
        ListNode attachHead = null;
        ListNode tracker = head;
        int tempM = m;
        while(tempM!=1){
            attachHead = tracker;
            tracker = tracker.next;
            tempM--;
        }
        ListNode revEnd = tracker;
        ListNode temp = tracker;
        tracker = tracker.next;
        int tempN = n;
        while(tempN!=m){
            ListNode next = tracker.next;
            tracker.next = temp;
            temp = tracker;
            tracker = next;
            tempN--;
        }
        if(attachHead==null){
            head = temp;
        }
        else{
            attachHead.next = temp;
        }
        revEnd.next = tracker;
        return head;
    }
}
