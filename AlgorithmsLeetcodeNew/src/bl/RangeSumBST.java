package bl;

import java.util.Stack;

/**
 * Created by Akshay Hegde on 10/12/2019.
 * 938. Range Sum of BST
 Easy

 541

 108

 Favorite

 Share
 Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

 The binary search tree is guaranteed to have unique values.



 Example 1:

 Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 Output: 32
 Example 2:

 Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 Output: 23


 Note:

 The number of nodes in the tree is at most 10000.
 The final answer is guaranteed to be less than 2^31.
 */
public class RangeSumBST {
    public int rangeSumBSTOld(TreeNode root, int L, int R) {
        if (root==null){
            return 0;
        }
        int sum =0;
        Stack<TreeNode> stack = new Stack<>();
        while (true){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }
            else{
                if(stack.isEmpty()){
                   return sum;
                }
                root = stack.pop();
                if(root.val==R){
                    sum+=root.val;
                    return sum;
                }
                if(root.val>=L&&root.val<R){
                    sum+=root.val;
                }
                root = root.right;
            }
        }
    }

    private int rangeSumBST(TreeNode root, int L, int R){
        if(root==null){
            return 0;
        }
        if(root.val==R){
            return root.val+ rangeSumBST(root.left,L,R);
        }
        if(root.val==L){
            return root.val+ rangeSumBST(root.right,L,R);
        }
        if(root.val>L&&root.val<R){
            return root.val+ rangeSumBST(root.left,L,R)+ rangeSumBST(root.right,L,R);
        }
        if(root.val>R){
            return rangeSumBST(root.left,L,R);
        }
        if(root.val<L){
            return rangeSumBST(root.right,L,R);
        }
        return 0;
    }
}
