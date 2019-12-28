package bl;

/**
 * Created by Akshay Hegde on 6/1/2019.
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 Example:

 Given the sorted linked list: [-10,-3,0,5,9],

 One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

 0
 / \
 -3   9
 /   /
 -10  5

 */
public class ListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next==null){
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);
        return node;
    }

}
