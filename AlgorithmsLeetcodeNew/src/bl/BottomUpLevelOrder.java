package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 6/1/2019.
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class BottomUpLevelOrder {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder =  new ArrayList<>();
        if(root==null){
            return levelOrder;
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(0,root);
        queue.add(0,null);
        List<Integer> line = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.remove(queue.size()-1);
            if(node!=null){
                line.add(node.val);
                if(node.left!=null){
                    queue.add(0,node.left);
                }
                if(node.right!=null){
                    queue.add(0,node.right);
                }
            }
            else{
                levelOrder.add(0,line);
                line = new ArrayList<>();
                if(!queue.isEmpty()) {
                    queue.add(0, null);
                }
            }
        }
        return levelOrder;
    }
}
