package bl;

/**
 * Created by Akshay Hegde on 7/16/2019.
 * Write a program to find the node at which the intersection of two singly linked lists begins.

 For example, the following two linked lists:


 begin to intersect at node c1.



 Example 1:


 Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 Output: Reference of the node with value = 8
 Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.


 Example 2:


 Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 Output: Reference of the node with value = 2
 Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.


 Example 3:


 Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 Output: null
 Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 Explanation: The two lists do not intersect, so return null.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null ||headB==null){
            return null;
        }
        ListNode newA = headA;
        ListNode newB = headB;
        boolean endA = false;
        boolean endB = false;
        while (true){
            if(newA.equals(newB)){
                return newA;
            }
            newA = newA.next;
            newB = newB.next;
            if(newA == null){
                if(!endA) {
                    newA = headB;
                    endA = true;
                }
                else {
                    return null;
                }
            }
            if (newB==null){
                if(!endB) {
                    newB = headA;
                    endB = true;
                }
                else{
                    return null;
                }
            }
        }
    }

    public static void main(String[] args) {
        ListNode headA = createListNode(new int[]{4,1,8,4,5});
        ListNode headB = createListNode(new int[]{4,1,8,4,5});

    }

    public static ListNode createListNode(int[] nums){
        if(nums.length==0){
            return null;
        }

        ListNode head = new ListNode(nums[0]);
        head.next = null;
        ListNode track = head;
        for (int i = 1; i < nums.length; i++) {
            track.next = new ListNode(nums[i]);
            track = track.next;
            track.next = null;
        }
        return head;
    }
}
