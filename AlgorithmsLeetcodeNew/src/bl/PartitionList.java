package bl;

/**
 * Created by Akshay Hegde on 5/25/2019.
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 Example:

 Input: head = 1->4->3->2->5->2, x = 3
 Output: 1->2->2->4->3->5


 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode leftHead = null;
        ListNode rightHead = null;
        ListNode leftPrev = null;
        ListNode rightPrev = null;

        ListNode node = head;
        while(node!=null){
            if(node.val<x){
                if(leftHead==null){
                    leftHead = node;
                    leftPrev = leftHead;
                }
                else{
                    leftPrev.next = node;
                    leftPrev = leftPrev.next;
                }
            }
            else{
                if(rightHead==null){
                    rightHead = node;
                    rightPrev = rightHead;
                }
                else{
                    rightPrev.next = node;
                    rightPrev = rightPrev.next;
                }
            }
            node = node.next;
        }

        if(leftHead==null||rightHead==null){
            return head;
        }
        leftPrev.next = rightHead;
        rightPrev.next=null;
        return leftHead;
    }
}
