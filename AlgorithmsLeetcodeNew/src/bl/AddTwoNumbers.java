package bl;

/**
 * Created by Akshay Hegde on 10/21/2019.
 * 445. Add Two Numbers II
 Medium

 901

 120

 Favorite

 Share
 You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Follow up:
 What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

 Example:

 Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 8 -> 0 -> 7

 */
public class AddTwoNumbers {
    class SumNode{
        int sum;
        int carry;

        public SumNode(int sum, int carry) {
            this.sum = sum;
            this.carry = carry;
        }

        public SumNode() {
            this.sum=0;
            this.carry = 0;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLen(l1);
        int len2 = getLen(l2);
        if(len1>len2){
            l2 = padZeros(l2,len1-len2);
        } else if(len2>len1){
            l1 =padZeros(l1,len2-len1);
        }
        SumNode sumNode = rec(l1,l2);
        if(sumNode.carry>0){
            ListNode node = new ListNode(sumNode.carry);
            node.next = l1;
            l1 = node;
        }
        return l1;
    }

    private SumNode rec(ListNode l1, ListNode l2){
        if(l1==null&&l2==null){
            return new SumNode();
        }
        SumNode sumNode = rec(l1.next,l2.next);
        int sum = l1.val+l2.val+sumNode.carry;
        int carry = sum/10;
        sum = sum%10;
        l1.val = sum;
        return new SumNode(sum,carry);
    }



    private int getLen(ListNode node){
        if(node==null){
            return 0;
        }
        return 1+ getLen(node.next);
    }

    private ListNode padZeros(ListNode head, int count){
        while (count>0){
            ListNode zeroNode =new ListNode(0);
            zeroNode.next = head;
            head =zeroNode;
            count--;
        }
        return head;
    }


}
