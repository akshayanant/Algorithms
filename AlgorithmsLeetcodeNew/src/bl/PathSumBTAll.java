package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 6/2/2019.
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 Note: A leaf is a node with no children.

 Example:

 Given the below binary tree and sum = 22,

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 Return:

 [
 [5,4,11,2],
 [5,8,4,5]
 ]

 */
public class PathSumBTAll {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        List<Integer> nodes = new ArrayList<>();
        recursion(root,nodes,res,sum);
        return res;
    }

    private void recursion(TreeNode root, List<Integer> nodes, List<List<Integer>> res,int sum) {
        if(root.left==null && root.right==null){
            if(sum-root.val==0){
                nodes.add(root.val);
                res.add(nodes);
                return;
            }
            return;
        }
        sum = sum-root.val;
        if(root.left!=null){
            List<Integer> listLeft = new ArrayList<>();
            listLeft.addAll(nodes);
            listLeft.add(root.val);
            recursion(root.left,listLeft,res,sum);
        }
        if(root.right!=null) {
            List<Integer> listRight = new ArrayList<>();
            listRight.addAll(nodes);
            listRight.add(root.val);
            recursion(root.right, listRight, res, sum);
        }
    }
}
