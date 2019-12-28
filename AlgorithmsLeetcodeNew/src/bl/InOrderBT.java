package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Akshay Hegde on 5/27/2019.
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.

 Example:

 Input: [1,null,2,3]
 1
 \
 2
 /
 3

 Output: [1,3,2]
 Follow up: Recursive solution is trivial, could you do it iteratively?

 */


  class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class InOrderBT {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }
            else{
                if(stack.empty()){
                    return res;
                }
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
    }
}
