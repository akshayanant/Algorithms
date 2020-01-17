package bl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Akshay Hegde on 1/17/2020.
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 Example 1:
 Input:
 3
 / \
 9  20
 /  \
 15   7
 Output: [3, 14.5, 11]
 Explanation:
 The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 Note:
 The range of node's value is in the range of 32-bit signed integer.

 */
public class AvgLevelBT {
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Double> res = new ArrayList<>();
        long runSum = 0;
        int count =0;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null){
                res.add(runSum/1.0/count);
                if(!q.isEmpty()){
                    q.add(null);
                    runSum = 0;
                    count =0;
                }
            }
            else{
                runSum+=node.val;
                count++;
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
        }
        return res;
    }
}
