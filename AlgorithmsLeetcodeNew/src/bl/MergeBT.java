package bl;

/**
 * Created by Akshay Hegde on 10/5/2019.
 * 617. Merge Two Binary Trees
 Easy

 2090

 142

 Favorite

 Share
 Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

 You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

 Example 1:

 Input:
 Tree 1                     Tree 2
 1                         2
 / \                       / \
 3   2                     1   3
 /                           \   \
 5                             4   7
 Output:
 Merged tree:
 3
 / \
 4   5
 / \   \
 5   4   7


 Note: The merging process must start from the root nodes of both trees.

 */
public class MergeBT {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null){
            return null;
        }
        TreeNode node = new TreeNode(0);
        TreeNode t1Left = null;
        TreeNode t1Right = null;
        TreeNode t2Left = null;
        TreeNode t2Right = null;

        if(t1!=null&&t2!=null){
            node.val = t1.val+t2.val;
            t1Left  = t1.left;
            t1Right = t1.right;
            t2Left = t2.left;
            t2Right = t2.right;
        }
        else if(t1==null){
            node.val=t2.val;
            t2Left = t2.left;
            t2Right = t2.right;
        }
        else{
           node.val = t1.val;
           t1Left = t1.left;
           t1Right = t1.right;
        }
        node.left = mergeTrees(t1Left,t2Left);
        node.right = mergeTrees(t1Right,t2Right);
        return node;
    }
}
