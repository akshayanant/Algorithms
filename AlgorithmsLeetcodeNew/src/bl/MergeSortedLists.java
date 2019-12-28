package bl;

/**
 * Created by Akshay Hegde on 4/10/2019.
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        while(l2!=null){
            ListNode node = new ListNode(l2.val);
            l1 = merge(l1,node);
            l2=l2.next;
        }
        return l1;
    }

    private ListNode merge(ListNode res,ListNode node){
        ListNode prev = null;
        ListNode cur = res;
        while(cur!=null){
            if(node.val<=cur.val){
                node.next = cur;
                if(prev==null){
                    prev=node;
                    return prev;
                }
                prev.next = node;
                return res;
            }
            prev = cur;
            cur = cur.next;
        }
        if(prev==null){
            return node;
        }
        prev.next = node;
        node.next = null;
        return res;
        }
    }


//    Runtime: 1 ms, faster than 91.22% of Java online submissions for Merge Two Sorted Lists.
//    Memory Usage: 37 MB, less than 97.95% of Java online submissions for Merge Two Sorted Lists.