package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Akshay Hegde on 6/21/2019.
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.

 Example:

 Input: [1,null,2,3]
 1
 \
 2
 /
 3

 Output: [1,2,3]
 Follow up: Recursive solution is trivial, could you do it iteratively?

 */
public class PreOrderBT {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if(root==null){
            return preOrder;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            preOrder.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return preOrder;
    }
}
