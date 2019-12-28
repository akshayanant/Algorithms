package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Akshay Hegde on 5/31/2019.
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]

 */
public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levelOrder =  new ArrayList<>();
        if(root==null){
            return levelOrder;
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(0,root);
        queue.add(0,null);
        List<Integer> line = new ArrayList<>();
        boolean leftToRight = true;
        Stack<TreeNode> stack = new Stack<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.remove(queue.size()-1);
            if(node!=null){
                if(leftToRight) {
                    line.add(node.val);
                }
                else{
                    stack.push(node);
                }
                if (node.left != null) {
                    queue.add(0, node.left);
                }
                if (node.right != null) {
                    queue.add(0, node.right);
                }
            }
            else{
                while (!stack.empty()){
                    line.add(stack.pop().val);
                }
                leftToRight=!leftToRight;
                levelOrder.add(line);
                line = new ArrayList<>();
                if(!queue.isEmpty()) {
                    queue.add(0, null);
                }
            }
        }
        return levelOrder;
    }
}
