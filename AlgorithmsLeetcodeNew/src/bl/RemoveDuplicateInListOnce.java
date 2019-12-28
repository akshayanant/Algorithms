package bl;

/**
 * Created by Akshay Hegde on 5/25/2019.
 *
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 Example 1:

 Input: 1->1->2
 Output: 1->2
 Example 2:

 Input: 1->1->2->3->3
 Output: 1->2->3>3
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }

 */
public class RemoveDuplicateInListOnce {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev = head;
        ListNode node = head.next;

        while(node!=null){
            if(node.val==prev.val){
                node = node.next;
                while (node!=null && node.val == prev.val){
                    node = node.next;
                }
                prev.next = node;
                prev = node;
                if(node!=null){
                    node = node.next;
                }
                else{
                    return head;
                }
            }
            else{
                prev.next = node;
                prev = node;
                node = node.next;
            }
        }
        prev.next = null;
        return head;
    }
}
