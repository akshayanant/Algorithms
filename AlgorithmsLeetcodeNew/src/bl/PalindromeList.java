package bl;

/**
 * Created by Akshay Hegde on 8/30/2019.
 *
 * 234. Palindrome Linked List
 Easy

 1891

 272

 Favorite

 Share
 Given a singly linked list, determine if it is a palindrome.

 Example 1:

 Input: 1->2
 Output: false
 Example 2:

 Input: 1->2->2->1
 Output: true
 Follow up:
 Could you do it in O(n) time and O(1) space?

 */
public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prevSlow = head;
        if(head==null||head.next==null){
            return true;
        }
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }
        //for odd
        if(fast!=null){
            slow = slow.next;
        }
        prevSlow.next=null;
        slow = rev(slow);
        while (head!=null){
            if(head.val!=slow.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode rev(ListNode head){
        if(head==null){
            return null;
        }
        ListNode prev = null;
        ListNode track = head;
        ListNode temp;
        while (track!=null){
            temp = track.next;
            track.next = prev;
            prev = track;
            track = temp;
        }
        return prev;
    }
}
