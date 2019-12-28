package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 9/23/2019.
 * 1161. Maximum Level Sum of a Binary Tree
 Medium

 85

 7

 Favorite

 Share
 Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

 Return the smallest level X such that the sum of all the values of nodes at level X is maximal.



 Example 1:



 Input: [1,7,0,7,-8,null,null]
 Output: 2
 Explanation:
 Level 1 sum = 1.
 Level 2 sum = 7 + 0 = 7.
 Level 3 sum = 7 + -8 = -1.
 So we return the level with the maximum sum which is level 2.

 */
public class MaxLevelSumBT {
    public int maxLevelSum(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        queue.add(0,root);
        queue.add(0,null);
        int max = root.val;
        int res = 1;
        int level =1;
        int sum =0;
        while (!queue.isEmpty()){
            TreeNode node = queue.remove(queue.size()-1);
            if(node!=null){
                sum+=node.val;
                if(node.left!=null){
                    queue.add(0,node.left);
                }
                if(node.right!=null){
                    queue.add(0,node.right);
                }
            }
            else{
                if(sum>max){
                    max = sum;
                    res = level;
                }
                sum =0;
                level++;
                if(!queue.isEmpty()) {
                    queue.add(0, null);
                }
            }
        }
        return res;
    }
}
