package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 8/20/2019.
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 Example:

 Input: [1,2,3,null,5,null,4]
 Output: [1, 3, 4]
 Explanation:

 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---

 */
public class RightSideViewBT {
    public List<Integer> rightSideView(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        queue.add(root);
        queue.add(null);
        while (true){
            int last = 0;
            while (queue.get(0)!=null){
                TreeNode node = queue.remove(0);
                last = node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(last);
            queue.remove(0);
            if (queue.isEmpty()){
                break;
            }
            queue.add(null);
        }
        return res;
    }
}
