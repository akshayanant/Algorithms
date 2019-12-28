package bl;

import java.util.ArrayList;

/**
 * Created by Akshay Hegde on 3/23/2019.
 * Given a linked list, remove the n-th node from the end of list and return its head.

 Example:

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:

 Given n will always be valid.

 Follow up:

 Could you do this in one pass?
 */


 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class RemoveNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        int count = traverse(head,listNodes);
        if(count == n){
            return head.next;
        }
        listNodes.get(count-n-1).next = listNodes.get(count-n+1);
        return head;
    }

    private int traverse(ListNode head,ArrayList<ListNode> nodes){
        int count = 0;
        while(head!=null){
            nodes.add(head);
            head = head.next;
            count++;
        }
        nodes.add(null);
        return count;
    }
}
