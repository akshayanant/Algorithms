package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Akshay Hegde on 9/5/2019.
 */
public class MinAbsDifferenceBST {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> inOrder = inorderTraversal(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < inOrder.size()-1; i++) {
            if(inOrder.get(i+1)-inOrder.get(i)<min){
                min = inOrder.get(i+1)-inOrder.get(i);
            }
        }
        return min;
    }

    private List<Integer> inorderTraversal(TreeNode root) {
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
