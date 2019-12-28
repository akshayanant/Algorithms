package bl;

import java.util.LinkedList;

/**
 * Created by Akshay Hegde on 10/20/2019.
 * 653. Two Sum IV - Input is a BST
 Easy

 1020

 117

 Favorite

 Share
 Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

 Example 1:

 Input:
 5
 / \
 3   6
 / \   \
 2   4   7

 Target = 9

 Output: True


 Example 2:

 Input:
 5
 / \
 3   6
 / \   \
 2   4   7

 Target = 28

 Output: False

 */
public class TwoSumIVBST {
    public boolean findTarget(TreeNode root, int k) {
        if (root==null){
            return false;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            TreeNode node = nodes.poll();
            if(node.left!=null){
                nodes.add(node.left);
            }
            if(node.right!=null){
                nodes.add(node.right);
            }
            int tar = k-node.val;
            if(tar==node.val){
                boolean res = rec(root,tar,2);
                if(res){
                    return true;
                }
            }
            else{
                boolean res = rec(root,tar,1);
                if(res){
                    return true;
                }
            }
        }
        return false;

    }

    private boolean rec(TreeNode root,int tar,int count){
        if(root==null){
            return false;
        }
        if(root.val==tar) {
            return count == 1 || rec(root.left, tar, count - 1);
        }
        if(root.val>tar){
            return rec(root.left,tar,count);
        }
        return rec(root.right,tar,count);
    }
}
