package bl; /**
 * Created by Akshay Hegde on 5/17/2019.
 *
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.

 Example 1:

 Input: 1->2->3->4->5->NULL, k = 2
 Output: 4->5->1->2->3->NULL
 Explanation:
 rotate 1 steps to the right: 5->1->2->3->4->NULL
 rotate 2 steps to the right: 4->5->1->2->3->NULL
 Example 2:

 Input: 0->1->2->NULL, k = 4
 Output: 2->0->1->NULL
 Explanation:
 rotate 1 steps to the right: 2->0->1->NULL
 rotate 2 steps to the right: 1->2->0->NULL
 rotate 3 steps to the right: 0->1->2->NULL
 rotate 4 steps to the right: 2->0->1->NULL
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null){
            return head;
        }
        int count =0;
        ListNode start = head;
        ListNode end = head;
        for (int i = 0; i < k && end!=null; i++) {
            end = end.next;
            count++;
        }
        if(end==null){
            k = k%count;
            if(k==0){
                return head;
            }
             start = head;
             end = head;
            for (int i = 0; i < k ; i++) {
                end = end.next;
            }
        }

        while(end.next!=null){
            start = start.next;
            end = end.next;
        }
        end.next = head;
        head = start.next;
        start.next = null;
        return head;
    }
}
