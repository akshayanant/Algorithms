package bl;

import java.util.ArrayList;

/**
 * Created by Akshay Hegde on 4/13/2019.
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 Example:

 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5

 Note:

 Only constant extra memory is allowed.
 You may not alter the values in the list's nodes, only nodes itself may be changed.


 */
public class ReveresNodesInGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1){
            return head;
        }
        ListNode pointer = new ListNode(1);
        pointer.next = head;
        ListNode newHead = reverse(head,k,pointer);
        ListNode groupHead = newHead;
        while(pointer.next!=null){
            for (int i = 0; i < k-1; i++) {
               groupHead = groupHead.next;
            }
            groupHead.next = (reverse(groupHead.next,k,pointer));
            groupHead = groupHead.next;
        }
        return newHead;


    }

    private ListNode reverse(ListNode head, int k,ListNode pointer){
        if(head==null){
            return head;
        }
        int count =0;
        ListNode temp = head;
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while(temp!=null&&count<k){
            listNodes.add(new ListNode(temp.val));
            temp = temp.next;
            count++;
        }
        if(count<k){
            pointer.next = null;
            return head;
        }
        ListNode nextNode = temp;
        ListNode newHead = listNodes.remove(listNodes.size()-1);
        ListNode cur = newHead;
        for (; listNodes.size()>0;) {
            cur.next = listNodes.remove(listNodes.size()-1);
            cur = cur.next;
        }
        cur.next = nextNode;
        pointer.next = nextNode;
        return newHead;
    }
}
