package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Akshay Hegde on 6/21/2019.
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.

 Example:

 Input: [1,null,2,3]
 1
 \
 2
 /
 3

 Output: [3,2,1]
 Follow up: Recursive solution is trivial, could you do it iteratively?

 */
public class PostOrderBT {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        if(root==null){
            return postOrder;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left!=null){
                stack1.push(node.left);
            }
            if(node.right!=null){
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()){
                postOrder.add(stack2.pop().val);
        }
        return postOrder;
    }
}
